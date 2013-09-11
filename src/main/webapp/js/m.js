var map1 = function(){
    var items = this.items;
    var lea = this.notes;
    var h1 = (this.homeGoal > this.guestGoal);
    for(var j=0;j<items.length;j++){
        var item = items[j];
        var hit = false;
        if(item.i4-item.i1 <= 0){
            if(h1) hit=true;
        }
        emit(item.name,{"lea": lea, "hit": hit, "m": true});
    }
};

var reduce1 = function(key,values){
    var r1 = {"name": key, "hitem": []};
    var r2 = {"name": key, "hitem": []};
    var mp = true;
    var vlen = values.length;
    for(var j=0;j<vlen;j++){
        var value = values[j];
        if(value.m){
            var hlen = r1.hitem.length;
            var hindex = -1;
            var fhitem = null;
            for(var k=0;k<hlen;k++){
                var hitem = r1.hitem[k];
                if(hitem.lea == value.lea){
                    hindex = k;
                    fhitem = hitem;
                    break;
                }
            }
            if(hindex != -1){
                if(value.hit) fhitem.hit++;
            }else{
                if(value.hit){
                    r1.hitem.push({"lea": value.lea,"hit": 1});
                }else{
                    r1.hitem.push({"lea": value.lea,"hit": 0});
                }
            }
        }else{
            mp = false;
            
            var olen = value.hitem.length;
            var oitems = value.hitem;
            var rlen = r2.hitem.length;
            for(var m=0;m<olen;m++){
                var rindex = -1;
                var rfhitem = null;
                var oitem = oitems[m];
                
                for(var k=0;k<hlen;k++){
                    var hitem = r2.hitem[k];
                    if(hitem.lea == oitem.lea){
                        hindex = k;
                        rfhitem = hitem;
                        break;
                    }
                }
                
                if(rindex != -1){
                    if(value.hit) r2.hitem[rindex].hit += oitem.hit;
                }else{
                    r2.hitem.push(oitem);
                }
            }
            
        }
    }
    
    printjsononeline({"mp": mp, "r1": r1, "r2": r2});
    
    if(mp){
        return r1;
    }else{
        return r2;
    }
};

db.match.mapReduce(map1,reduce1,{out: "reduced"});