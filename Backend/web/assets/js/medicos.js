/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var Medicos = function(){
    self = this;
    this.medico = null;
    this.servico = "/Backend/agenda/medicos";
    this.paginaLista = "/Backend/medicoLista.html";
    this.paginaCadastro = "/Backend/medicoCadastro.html";
    this.paginaEdicao = "/Backend/medicoCadastro.html?id={_id}";
    this.templateLista = null;
    this.prefix = "medico";
    this.form = null;
};
Medicos.prototype = {
    Initilize : function(){
        this.form = $(".medicos");
        processamento.iniciar('medicos-template-lista');
        requisicaoAjax("assets/template/medicos-lista.html", "get", {}, 
            function(data){
                self.templateLista = data;
                processamento.terminar('medicos-template-lista');
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
                processamento.terminar('medicos');
                requisicaoAjax(this.servico+"/"+self.getQuerystringId(), "get", {}, 
                    function(data){
                        if(data){
                            $("#id").val(data[self.prefix + "Id"]);
                            $("#nome").val(data[self.prefix + "Nome"]);
                            self.carregarComboEspecialidades(data[self.prefix + "Id"]);
                        }
                        
                        self.form.bind('submit', function(){
                            medicos.atualizar();
                            return false;
                        });
                        processamento.terminar('medicos');
                    }, 
                    function(data){
                    //error
                    });
                break;
            case 'post':
            default:
                self.carregarComboEspecialidades(null);
                self.form.bind('submit', function(){
                    medicos.cadastrar();
                    return false;
                });
                break;
                
        }
    },
    carregarComboEspecialidades : function(id){
        especialidades.get(id, function(data){
            var htmlCombo = [];
            htmlCombo.push('<select id="id-especialidade" name="id-especialidade">');
            htmlCombo.push('<option>-selecione-</option>');
            var prefix = especialidades.prefix;
            for(var especialidade in data.especialidades){
                var item = data.especialidades[especialidade];
                htmlCombo.push('<option value="');
                htmlCombo.push(item[prefix + "Id"]);
                if(id && id == item[prefix + "Id"])
                    htmlCombo.push(' selected ');
                htmlCombo.push('" >');
                htmlCombo.push(item[prefix + "Nome"]);
                htmlCombo.push('</option>');
            }
            htmlCombo.push('</select>');
            var html = $.parseHTML(htmlCombo.join('')); 
            $("#id-especialidade").remove();
            $(".label-id-especialidade").after(html);
        });
    },
    listar : function(){
        processamento.iniciar('medicos');
        requisicaoAjax(this.servico, "get", {}, 
            function(data){
                console.log('data', data.medicos);
                var htmlLista = [];
                var odd = true;
                $('.medicos .rows').remove();
                for(var medico in data.medicos){
                    var item = data.medicos[medico];
                    console.log('item', item);
                    htmlLista.push(self.templateLista.replaceAll('{id}', item[self.prefix + "Id"])
                        .replaceAll('{nome}', item[self.prefix + "Nome"])
                        .replaceAll('{odd}', (odd)?'pure-table-odd':''));
                    odd = !odd;                                 
                    
                }
                var html = $.parseHTML(htmlLista.join(''));
                $('.medicos tbody').append(html);
                $(".medicos .delete").bind('click', function(){
                    if(confirm('Excluir?')){
                        self.excluir($(this).data("id"));
                    }
                });
                processamento.terminar('medicos');
            }, 
            function(data){
            //error
            });
    },
    get : function(){
        
    },
    atualizar : function(){
        processamento.iniciar('medicos');
        requisicaoAjax(this.servico, "put", self.form.serialize(), 
            function(data){
                document.location.href = self.paginaLista;
                console.log('data', data);
                processamento.terminar('medicos');
            }, 
            function(data){
            //error
            });
    }, 
    cadastrar : function(){
        processamento.iniciar('medicos');
        console.log('dados',self.form.serialize());
        requisicaoAjax(this.servico, "post", self.form.serialize(), 
            function(data){
                document.location.href = self.paginaLista;
                console.log('data', data);
                processamento.terminar('medicos');
            }, 
            function(data){
            //error
            });
    },
    excluir : function(id){
        processamento.iniciar('medicos');
        requisicaoAjax(this.servico, "delete", {
            "id":id
        }, 
        function(data){
            self.listar();
            processamento.terminar('medicos');
        }, 
        function(data){
            //error
            });
    }
};

Medicos.Load = function(){
    var _data = new Medicos();
    _data.Initilize();
    return _data;
};
var medicos = Medicos.Load();

$(document).on('submit', '.medicos', function(){
    medicos.cadastrar();
    return false;
});

$(document).ready(function(){
    var pagina = document.location.href;
    if(pagina.indexOf('Cadastro') > -1 && pagina.indexOf('?id=') > -1){
        medicos.prepararFormulario("put");
    }else if(pagina.indexOf('Cadastro') > -1){
        medicos.prepararFormulario("post");
        
    }else if(pagina.indexOf('Lista') > -1){
        medicos.listar();
    }
})

