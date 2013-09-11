var map1 = function(){
    var items = this.items;
    var lea = this.notes;
    var h1 = (this.homeGoal > this.guestGoal);
    var h2 = (this.homeGoal == this.guestGoal);
    var h3 = (this.homeGoal < this.guestGoal);
    
    for(var j=0;j<items.length;j++){
        var item = items[j];
        var hit = false;
        if(item.i4-item.i1 <= 0){
            if(h1) hit=true;
        }
        if(item.i5-item.i2 <=0 ){
            if(h2) hit=true;
        }
        if(item.i6-item.i4 <=0 ){
            if(h3) hit=true;
        }
        emit(item.name,{"lea": lea, "match": 1, "hit": hit, "m": true});
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
                fhitem.match++;
            }else{
                if(value.hit){
                    r1.hitem.push({"lea": value.lea, "match": 1, "hit": 1});
                }else{
                    r1.hitem.push({"lea": value.lea, "match": 1, "hit": 0});
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
                
                for(var k=0;k<rlen;k++){
                    var hitem = r2.hitem[k];
                    if(hitem.lea == oitem.lea){
                        rindex = k;
                        rfhitem = hitem;
                        break;
                    }
                }
                
                //printjsononeline({"index": rindex, "oitem": oitem, "r2.hitem": r2.hitem});
                
                if(rindex != -1){
                    r2.hitem[rindex].hit = (r2.hitem[rindex].hit + oitem.hit);
                    r2.hitem[rindex].match = (r2.hitem[rindex].match + oitem.match);
                }else{
                    r2.hitem.push(oitem);
                }
            }
            
        }
    }
    
    if(mp){
        //printjsononeline({"r1": r1});
        return r1;
    }else{
        //printjsononeline({"r2": r2, "values": values});
        return r2;
    }
};

db.match.mapReduce(map1,reduce1,{out: "reduced"});