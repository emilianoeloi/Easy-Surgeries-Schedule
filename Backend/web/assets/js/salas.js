/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var Salas = function(){
    self = this;
    this.sala = null;
    this.servico = "/Backend/agenda/salas";
    this.paginaLista = "/Backend/salaLista.html";
    this.paginaCadastro = "/Backend/salaCadastro.html";
    this.paginaEdicao = "/Backend/salaCadastro.html?id={_id}";
    this.templateLista = null;
    this.prefix = "sala";
    this.form = null;
};
Salas.prototype = {
    Initilize : function(){
        this.form = $(".salas");
        processamento.iniciar('salas-template-lista');
        requisicaoAjax("assets/template/salas-lista.html", "get", {}, 
            function(data){
                self.templateLista = data;
                processamento.terminar('salas-template-lista');
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
                processamento.terminar('salas');
                requisicaoAjax(this.servico+"/"+self.getQuerystringId(), "get", {}, 
                    function(data){
                        if(data){
                            $("#id").val(data[self.prefix + "Id"]);
                            $("#numero").val(data[self.prefix + "Numero"]);
                        }
                        self.form.bind('submit', function(){
                            salas.atualizar();
                            return false;
                        });
                        processamento.terminar('salas');
                    }, 
                    function(data){
                    //error
                    });
                break;
            case 'post':
            default:
                self.form.bind('submit', function(){
                    salas.cadastrar();
                    return false;
                });
                break;
                
        }
    },
    listar : function(){
        processamento.iniciar('salas');
        requisicaoAjax(this.servico, "get", {}, 
            function(data){
                console.log('data', data.salas);
                var htmlLista = [];
                var odd = true;
                $('.salas .rows').remove();
                for(var sala in data.salas){
                    var item = data.salas[sala];
                    console.log('item', item);
                    htmlLista.push(self.templateLista.replaceAll('{id}', item[self.prefix + "Id"])
                        .replaceAll('{numero}', item[self.prefix + "Numero"])
                        .replaceAll('{odd}', (odd)?'pure-table-odd':''));
                    odd = !odd;                                 
                    
                }
                var html = $.parseHTML(htmlLista.join(''));
                $('.salas tbody').append(html);
                $(".salas .delete").bind('click', function(){
                    if(confirm('Excluir?')){
                        self.excluir($(this).data("id"));
                    }
                });
                processamento.terminar('salas');
            }, 
            function(data){
            //error
            });
    },
    get : function(){
        
    },
    atualizar : function(){
        processamento.iniciar('salas');
        requisicaoAjax(this.servico, "put", self.form.serialize(), 
            function(data){
                document.location.href = self.paginaLista;
                console.log('data', data);
                processamento.terminar('salas');
            }, 
            function(data){
            //error
            });
    }, 
    cadastrar : function(){
        processamento.iniciar('salas');
        requisicaoAjax(this.servico, "post", self.form.serialize(), 
            function(data){
                document.location.href = self.paginaLista;
                console.log('data', data);
                processamento.terminar('salas');
            }, 
            function(data){
            //error
            });
    },
    excluir : function(id){
        processamento.iniciar('salas');
        requisicaoAjax(this.servico, "delete", {"id":id}, 
            function(data){
                self.listar();
                processamento.terminar('salas');
            }, 
            function(data){
            //error
            });
    }
};

Salas.Load = function(){
    var _data = new Salas();
    _data.Initilize();
    return _data;
};
var salas = Salas.Load();

$(document).on('submit', '.salas', function(){
    salas.cadastrar();
    return false;
});

$(document).ready(function(){
    var pagina = document.location.href;
    if(pagina.indexOf('Cadastro') > -1 && pagina.indexOf('?id=') > -1){
        salas.prepararFormulario("put");
    }else if(pagina.indexOf('Cadastro') > -1){
        salas.prepararFormulario("post");
        
    }else if(pagina.indexOf('Lista') > -1){
        salas.listar();
    }
})

