function buildUrl(){
    var qs = '?debug=true';

    with(location){
        var url = href + qs
    }

    return url;
}