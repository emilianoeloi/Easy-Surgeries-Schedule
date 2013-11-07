/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    /// Carregar cabeçalho
    processamento.iniciar('layout');
    requisicaoAjax("assets/template/cabecalho.html", "get", {}, 
        function(data){
            data = data.replaceAll("{data-atual}", getDataAtual());
            var html = $.parseHTML(data);
            $("#layout-cabecalho").val('');
            $(".cabecalho").after(html);
            processamento.terminar('layout');
        }, 
        function(data){
        
        });

    /// Carregar menu
    processamento.iniciar('layout');
    requisicaoAjax("assets/template/menu.html", "get", {}, 
        function(data){
            //data = data.replaceAll("{data-atual}", getDataAtual());
            var html = $.parseHTML(data);
            $("#layout-menu").val('');
            $(".menu").after(html);
            processamento.terminar('layout');
        }, 
        function(data){
        
        });
    
    /// Carregar rodapé
    processamento.iniciar('layout');
    requisicaoAjax("assets/template/rodape.html", "get", {}, 
        function(data){
            //data = data.replaceAll("{data-atual}", getDataAtual());
            var html = $.parseHTML(data);
            $("#layout-rodape").val('');
            $(".rodape").after(html);
            processamento.terminar('layout');
        }, 
        function(data){
        
        });    
     

});