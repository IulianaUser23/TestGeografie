/**
 * Created by IulianaUser23 on 04.08.2017.
 */

function listInvat(listaCapitaleJson) {
    var list = document.getElementById('listDeInvatat');
    var listHtml = '';

    for (var i = 0; i < listaCapitaleJson.length; i++) {
        var lCompleta = listaCapitaleJson[i];
        listHtml = listHtml + lCompleta.capitala + '&nbsp;' + lCompleta.numeTara +
                                                   '&nbsp;' + lCompleta.continent + '</br>';
    }
    list.innerHTML = listHtml;
}
function listDeInvatat() {
    $.ajax({
        url: 'invaturl?action=list'
    }).done(function (response) {
        listInvat(response.listaCapitaleJson);
    })
}




