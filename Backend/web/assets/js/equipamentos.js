/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var Equipamentos = function(){
    self = this;
    this.equipamento = null;
    this.servico = "/Backend/agenda/equipamentos";
    this.templateLista = null;
    this.prefix = "equipamento";
};
Equipamentos.prototype = {
    Initilize : function(){
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
    carregarDados : function(){
        self.equipamento = {};
        self.equipamento.descricao = $("#descricao").val();
        self.equipamento.qtde = $("#qtde").val();
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
        
    }, 
    cadastrar : function(){
        this.carregarDados();
        processamento.iniciar('equipamentos');
        requisicaoAjax(this.servico, "post", {} /* {"descricao": self.equipamento.descricao, "qtd": self.equipamento.qtde}*/, 
            function(data){
                
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
    if(pagina.indexOf('Cadastro') > -1){
        
    }else if(pagina.indexOf('Lista') > -1){
        equipamentos.listar();
    }
})

