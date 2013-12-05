/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var Equipamentos = function(){
    self = this;
    this.agendamento = null;
    this.servico = "/Backend/agenda/agendamentos";
    this.paginaLista = "/Backend/agendamentoLista.html";
    this.paginaCadastro = "/Backend/agendamentoCadastro.html";
    this.paginaEdicao = "/Backend/agendamentoCadastro.html?id={_id}";
    this.templateLista = null;
    this.templateSalasDisponiveis = null;
    this.prefix = "agendamento";
    this.form = null;
};
Equipamentos.prototype = {
    Initilize : function(){
        this.form = $(".agendamentos");
        processamento.iniciar('agendamentos-template-lista');
        requisicaoAjax("assets/template/agendamentos-lista.html", "get", {}, 
            function(data){
                self.templateLista = data;
                processamento.terminar('agendamentos-template-lista');
            }, 
            function(data){
            // Error
            });
        processamento.iniciar('agendamentos-template-lista');
        requisicaoAjax("assets/template/agendamentos-salas-disponiveis-lista.html", "get", {}, 
            function(data){
                self.templateSalasDisponiveis = data;
                processamento.terminar('agendamentos-template-lista');
            }, 
            function(data){
            // Error
            });     
    },
    getQuerystringId : function(){
        return getParameterByName("id");
    },
    prepararBuscaSalas : function(){
        $("#btn-buscar-salas").bind('click', function(){
            processamento.iniciar('agendamentos');
            if($("#data-inicio").val() != '' && $("#data-termino").val() != ''){
                requisicaoAjax(self.servico+"/buscarsalas/"+$("#data-inicio").val()+"/"+$("#data-termino").val()+"?_="+new Date().getTime(), "get", 
                {}, 
                    function(data){
                        var htmlLista = [];
                        var odd = true;
                        $('.salas-disponiveis .rows').remove();
                        for(var sala in data.salas){
                            var item = data.salas[sala];
                            htmlLista.push(self.templateSalasDisponiveis.replaceAll('{id}', item["salaId"])
                                .replaceAll('{numero}', item["salaNumero"])
                                .replaceAll('{odd}', (odd)?'pure-table-odd':''));
                            odd = !odd;                                 
                    
                        }
                        var html = $.parseHTML(htmlLista.join(''));
                        $('.salas-disponiveis tbody').append(html);
                        $(".salas-disponiveis .agendar").bind('click', function(){
                            console.log('vai sabrina');
                        });
                        processamento.terminar('agendamentos');
                    }, 
                    function(data){
                        console.error(data);
                        processamento.terminar('agendamentos');
                    });
            }else{
                processamento.terminar('agendamentos');
            }
        });
    },
    prepararFormulario : function(metodo){
        self.form.attr('method', metodo);
        self.form.attr('action', self.servico);
        switch(metodo){
            case 'put':
                processamento.iniciar('agendamentos');
                requisicaoAjax(this.servico+"/"+self.getQuerystringId()+"?_="+new Date().getTime(), "get", {}, 
                    function(data){
                        if(data){
                            $("#id").val(data[self.prefix + "Id"]);
                            $("#descricao").val(data[self.prefix + "Descricao"]);
                            $("#qtd").val(data[self.prefix + "QtdeDisponivel"]);
                        }
                        self.form.bind('submit', function(){
                            agendamentos.atualizar();
                            return false;
                        });
                        processamento.terminar('agendamentos');
                    }, 
                    function(data){
                    //error
                    });
                break;
            case 'post':
            default:
                self.form.bind('submit', function(){
                    agendamentos.cadastrar();
                    return false;
                });
                break;
                
        }
    },
    listar : function(){
        processamento.iniciar('agendamentos');
        requisicaoAjax(this.servico+"?_="+new Date().getTime(), "get", {}, 
            function(data){
                var htmlLista = [];
                var odd = true;
                $('.agendamentos .rows').remove();
                for(var agendamento in data.agendamentos){
                    var item = data.agendamentos[agendamento];
                    htmlLista.push(self.templateLista.replaceAll('{id}', item[self.prefix + "Id"])
                        .replaceAll('{descricao}', item[self.prefix + "Descricao"])
                        .replaceAll('{qtde}', item[self.prefix + "QtdeDisponivel"])
                        .replaceAll('{odd}', (odd)?'pure-table-odd':''));
                    odd = !odd;                                 
                    
                }
                var html = $.parseHTML(htmlLista.join(''));
                $('.agendamentos tbody').append(html);
                $(".agendamentos .delete").bind('click', function(){
                    if(confirm('Excluir?')){
                        self.excluir($(this).data("id"));
                    }
                });
                processamento.terminar('agendamentos');
            }, 
            function(data){
            //error
            });
    },
    get : function(){
        
    },
    atualizar : function(){
        processamento.iniciar('agendamentos');
        requisicaoAjax(this.servico, "put", self.form.serialize(), 
            function(data){
                document.location.href = self.paginaLista;
                console.log('data', data);
                processamento.terminar('agendamentos');
            }, 
            function(data){
            //error
            });
    }, 
    cadastrar : function(){
        processamento.iniciar('agendamentos');
        requisicaoAjax(this.servico, "post", self.form.serialize(), 
            function(data){
                document.location.href = self.paginaLista;
                console.log('data', data);
                processamento.terminar('agendamentos');
            }, 
            function(data){
            //error
            });
    },
    excluir : function(id){
        processamento.iniciar('agendamentos');
        requisicaoAjax(this.servico, "delete", {
            "id":id
        }, 
        function(data){
            self.listar();
            processamento.terminar('agendamentos');
        }, 
        function(data){
            //error
            });
    }
};

Equipamentos.Load = function(){
    var _data = new Equipamentos();
    _data.Initilize();
    return _data;
};
var agendamentos = Equipamentos.Load();

$(document).on('submit', '.agendamentos', function(){
    agendamentos.cadastrar();
    return false;
});

$(document).ready(function(){
    var pagina = document.location.href;
    if(pagina.indexOf('Cadastro') > -1 && pagina.indexOf('?id=') > -1){
        agendamentos.prepararFormulario("put");
    }else if(pagina.indexOf('Cadastro') > -1){
        agendamentos.prepararBuscaSalas();
        agendamentos.prepararFormulario("post");
        
    }else if(pagina.indexOf('Lista') > -1){
        agendamentos.listar();
    }
})

