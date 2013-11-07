/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var Materiais = function(){
    self = this;
    this.material = null;
    this.servico = "/Backend/agenda/materiais";
    this.paginaLista = "/Backend/materialLista.html";
    this.paginaCadastro = "/Backend/materialCadastro.html";
    this.paginaEdicao = "/Backend/materialCadastro.html?id={_id}";
    this.templateLista = null;
    this.prefix = "material";
    this.form = null;
};
Materiais.prototype = {
    Initilize : function(){
        this.form = $(".materiais");
        processamento.iniciar('materiais-template-lista');
        requisicaoAjax("assets/template/materiais-lista.html", "get", {}, 
            function(data){
                self.templateLista = data;
                processamento.terminar('materiais-template-lista');
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
                processamento.terminar('materiais');
                requisicaoAjax(this.servico+"/"+self.getQuerystringId(), "get", {}, 
                    function(data){
                        if(data){
                            $("#id").val(data[self.prefix + "Id"]);
                            $("#descricao").val(data[self.prefix + "Descricao"]);
                            $("#qtd").val(data[self.prefix + "QtdeDisponivel"]);
                        }
                        self.form.bind('submit', function(){
                            materiais.atualizar();
                            return false;
                        });
                        processamento.terminar('materiais');
                    }, 
                    function(data){
                    //error
                    });
                break;
            case 'post':
            default:
                self.form.bind('submit', function(){
                    materiais.cadastrar();
                    return false;
                });
                break;
                
        }
    },
    listar : function(){
        processamento.iniciar('materiais');
        requisicaoAjax(this.servico, "get", {}, 
            function(data){
                console.log('listar', data);
                var htmlLista = [];
                var odd = true;
                $('.materiais .rows').remove();
                for(var material in data.materiais){
                    var item = data.materiais[material];
                    htmlLista.push(self.templateLista.replaceAll('{id}', item[self.prefix + "Id"])
                        .replaceAll('{descricao}', item[self.prefix + "Descricao"])
                        .replaceAll('{qtde}', item[self.prefix + "QtdeDisponivel"])
                        .replaceAll('{odd}', (odd)?'pure-table-odd':''));
                    odd = !odd;                                 
                    
                }
                var html = $.parseHTML(htmlLista.join(''));
                $('.materiais tbody').append(html);
                $(".materiais .delete").bind('click', function(){
                    if(confirm('Excluir?')){
                        self.excluir($(this).data("id"));
                    }
                });
                processamento.terminar('materiais');
            }, 
            function(data){
            //error
            });
    },
    get : function(){
        
    },
    atualizar : function(){
        processamento.iniciar('materiais');
        requisicaoAjax(this.servico, "put", self.form.serialize(), 
            function(data){
                document.location.href = self.paginaLista;
                console.log('data', data);
                processamento.terminar('materiais');
            }, 
            function(data){
            //error
            });
    }, 
    cadastrar : function(){
        processamento.iniciar('materiais');
        requisicaoAjax(this.servico, "post", self.form.serialize(), 
            function(data){
                document.location.href = self.paginaLista;
                console.log('data', data);
                processamento.terminar('materiais');
            }, 
            function(data){
            //error
            });
    },
    excluir : function(id){
        processamento.iniciar('materiais');
        requisicaoAjax(this.servico, "delete", {"id":id}, 
            function(data){
                self.listar();
                processamento.terminar('materiais');
            }, 
            function(data){
            //error
            });
    }
};

Materiais.Load = function(){
    var _data = new Materiais();
    _data.Initilize();
    return _data;
};
var materiais = Materiais.Load();

$(document).on('submit', '.materiais', function(){
    materiais.cadastrar();
    return false;
});

$(document).ready(function(){
    var pagina = document.location.href;
    if(pagina.indexOf('Cadastro') > -1 && pagina.indexOf('?id=') > -1){
        materiais.prepararFormulario("put");
    }else if(pagina.indexOf('Cadastro') > -1){
        materiais.prepararFormulario("post");
        
    }else if(pagina.indexOf('Lista') > -1){
        materiais.listar();
    }
})

