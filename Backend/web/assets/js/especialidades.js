/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var Especialidades = function(){
    self = this;
    this.especialidade = null;
    this.servico = "/Backend/agenda/especialidades";
    this.paginaLista = "/Backend/especialidadeLista.html";
    this.paginaCadastro = "/Backend/especialidadeCadastro.html";
    this.paginaEdicao = "/Backend/especialidadeCadastro.html?id={_id}";
    this.templateLista = null;
    this.prefix = "especialidade";
    this.form = null;
};
Especialidades.prototype = {
    Initilize : function(){
        this.form = $(".especialidades");
        processamento.iniciar('especialidades-template-lista');
        requisicaoAjax("assets/template/especialidades-lista.html", "get", {}, 
            function(data){
                self.templateLista = data;
                processamento.terminar('especialidades-template-lista');
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
                processamento.terminar('especialidades');
                requisicaoAjax(this.servico+"/"+self.getQuerystringId(), "get", {}, 
                    function(data){
                        if(data){
                            $("#id").val(data[self.prefix + "Id"]);
                            $("#descricao").val(data[self.prefix + "Descricao"]);
                            $("#nome").val(data[self.prefix + "Nome"]);
                        }
                        self.form.bind('submit', function(){
                            especialidades.atualizar();
                            return false;
                        });
                        processamento.terminar('especialidades');
                    }, 
                    function(data){
                    //error
                    });
                break;
            case 'post':
            default:
                self.form.bind('submit', function(){
                    especialidades.cadastrar();
                    return false;
                });
                break;
                
        }
    },
    listar : function(){
        processamento.iniciar('especialidades');
        requisicaoAjax(this.servico, "get", {}, 
            function(data){
                var htmlLista = [];
                var odd = true;
                $('.especialidades .rows').remove();
                for(var especialidade in data.especialidades){
                    var item = data.especialidades[especialidade];
                    htmlLista.push(self.templateLista.replaceAll('{id}', item[self.prefix + "Id"])
                        .replaceAll('{descricao}', item[self.prefix + "Descricao"])
                        .replaceAll('{nome}', item[self.prefix + "Nome"])
                        .replaceAll('{odd}', (odd)?'pure-table-odd':''));
                    odd = !odd;                                 
                    
                }
                var html = $.parseHTML(htmlLista.join(''));
                $('.especialidades tbody').append(html);
                $(".especialidades .delete").bind('click', function(){
                    if(confirm('Excluir?')){
                        self.excluir($(this).data("id"));
                    }
                });
                processamento.terminar('especialidades');
            }, 
            function(data){
            //error
            });
    },
    get : function(id, funcaoCallback){
        if(id){
            requisicaoAjax(this.servico + '/' + id, "get", self.form.serialize(), 
                funcaoCallback, 
                function(data){
                //error
                });
        }else{
            requisicaoAjax(this.servico, "get", self.form.serialize(), 
                funcaoCallback, 
                function(data){
                //error
                });
        }
        
    },
    atualizar : function(){
        processamento.iniciar('especialidades');
        requisicaoAjax(this.servico, "put", self.form.serialize(), 
            function(data){
                document.location.href = self.paginaLista;
                console.log('data', data);
                processamento.terminar('especialidades');
            }, 
            function(data){
            //error
            });
    }, 
    cadastrar : function(){
        processamento.iniciar('especialidades');
        requisicaoAjax(this.servico, "post", self.form.serialize(), 
            function(data){
                document.location.href = self.paginaLista;
                console.log('data', data);
                processamento.terminar('especialidades');
            }, 
            function(data){
            //error
            });
    },
    excluir : function(id){
        processamento.iniciar('especialidades');
        requisicaoAjax(this.servico, "delete", {"id":id}, 
            function(data){
                self.listar();
                processamento.terminar('especialidades');
            }, 
            function(data){
            //error
            });
    }
};

Especialidades.Load = function(){
    var _data = new Especialidades();
    _data.Initilize();
    return _data;
};
var especialidades = Especialidades.Load();

$(document).on('submit', '.especialidades', function(){
    especialidades.cadastrar();
    return false;
});

$(document).ready(function(){
    var pagina = document.location.href;
    if(pagina.indexOf('especialidade') > -1){
        if(pagina.indexOf('Cadastro') > -1 && pagina.indexOf('?id=') > -1){
            especialidades.prepararFormulario("put");
        }else if(pagina.indexOf('Cadastro') > -1){
            especialidades.prepararFormulario("post");

        }else if(pagina.indexOf('Lista') > -1){
            especialidades.listar();
        }
    }
});

