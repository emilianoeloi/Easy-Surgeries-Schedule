/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var Processamento = function(){
    self = this;
    this.processamentos = null;
};
Processamento.prototype = {
    Initilize : function(){
        this.processamentos = {};
    },
    iniciar : function(processo){
        if(this.processamentos[processo] >= 0)
            this.processamentos[processo] ++;
        else
            this.processamentos[processo] = 1;
        
        if(this.processamentos[processo] == 1)
            this.mostrarCarregando();
    },
    terminar : function(processo){
        if(this.processamentos[processo] >= 0)
            this.processamentos[processo]--;
        else
            this.processamentos[processo] = 0;
        
        if(this.processamentos[processo] == 0)
            this.esconderCarregando();
    },
    mostrarCarregando : function(){
        $(".carregando").removeClass('hidden');
    },
    esconderCarregando : function(){
        $(".carregando").addClass('hidden');
    },
    mostrarProcessamentos : function(){
        console.log('Processamentos', this.processamentos);
    }
};

Processamento.Load = function(){
    var _data = new Processamento();
    _data.Initilize();
    return _data;
};
var processamento = Processamento.Load();

