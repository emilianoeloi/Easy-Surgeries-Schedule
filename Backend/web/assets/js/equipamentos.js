/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var Equipamentos = function(){
    self = this;
    this.equipamento = null;
    this.servico = "/Backend/agenda/equipamentos";
    this.paginaLista = "/Backend/equipamentoLista.html";
    this.paginaCadastro = "/Backend/equipamentoCadastro.html";
    this.paginaEdicao = "/Backend/equipamentoCadastro.html?id={_id}";
    this.templateLista = null;
    this.prefix = "equipamento";
    this.form = null;
};
Equipamentos.prototype = {
    Initilize : function(){
        this.form = $(".equipamentos");
        processamento.iniciar('equipamentos-template-lista');
        requisicaoAjax("assets/template/equipamentos-lista.html", "get", {}, 
            function(data){
                self.templateLista = data;
                processamento.terminar('equipamentos-template-lista');
            }, 
            function(data){
            // Error
            });
    },
    getQuerystringId : function(){
        return getParameterByName("id");
    },
    prepararFormulario : function(metodo){
        self.form.attr('method', metodo);
        self.form.attr('action', self.servico);
        switch(metodo){
            case 'put':
                processamento.terminar('equipamentos');
                requisicaoAjax(this.servico+"/"+self.getQuerystringId(), "get", {}, 
                    function(data){
                        if(data){
                            $("#id").val(data[self.prefix + "Id"]);
                            $("#descricao").val(data[self.prefix + "Descricao"]);
                            $("#qtd").val(data[self.prefix + "QtdeDisponivel"]);
                        }
                        self.form.bind('submit', function(){
                            equipamentos.atualizar();
                            return false;
                        });
                        processamento.terminar('equipamentos');
                    }, 
                    function(data){
                    //error
                    });
                break;
            case 'post':
            default:
                self.form.bind('submit', function(){
                    equipamentos.cadastrar();
                    return false;
                });
                break;
                
        }
    },
    listar : function(){
        processamento.iniciar('equipamentos');
        requisicaoAjax(this.servico, "get", {}, 
            function(data){
                var htmlLista = [];
                var odd = true;
                for(var equipamento in data.equipamentos){
                    var item = data.equipamentos[equipamento];
                    htmlLista.push(self.templateLista.replaceAll('{id}', item[self.prefix + "Id"])
                        .replaceAll('{descricao}', item[self.prefix + "Descricao"])
                        .replaceAll('{qtde}', item[self.prefix + "QtdeDisponivel"])
                        .replaceAll('{odd}', (odd)?'pure-table-odd':''));
                    odd = !odd;                                 
                    
                }
                var html = $.parseHTML(htmlLista.join(''));
                $('.equipamentos tbody').append(html)
                processamento.terminar('equipamentos');
            }, 
            function(data){
            //error
            });
    },
    get : function(){
        
    },
    atualizar : function(){
        processamento.iniciar('equipamentos');
        requisicaoAjax(this.servico, "put", self.form.serialize(), 
            function(data){
                document.location.href = self.paginaLista;
                console.log('data', data);
                processamento.terminar('equipamentos');
            }, 
            function(data){
            //error
            });
    }, 
    cadastrar : function(){
        processamento.iniciar('equipamentos');
        requisicaoAjax(this.servico, "post", self.form.serialize(), 
            function(data){
                document.location.href = self.paginaLista;
                console.log('data', data);
                processamento.terminar('equipamentos');
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
var equipamentos = Equipamentos.Load();

$(document).on('submit', '.equipamentos', function(){
    equipamentos.cadastrar();
    return false;
});

$(document).ready(function(){
    var pagina = document.location.href;
    if(pagina.indexOf('Cadastro') > -1 && pagina.indexOf('?id=') > -1){
        equipamentos.prepararFormulario("put");
    }else if(pagina.indexOf('Cadastro') > -1){
        equipamentos.prepararFormulario("post");
        
    }else if(pagina.indexOf('Lista') > -1){
        equipamentos.listar();
    }
})

