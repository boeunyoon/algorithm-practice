function solution(s){
    var answer = true;
    var stack = [];
    
    for(let i = 0; i < s.length; i++){
        let st = s[i];
        let p = ""
        if(stack.length != 0){
            p = stack.pop();
        }else{
            stack.push(st);
            continue;
        }
        
        if(p == "(" && st == ")"){
            continue;
        }else{
            stack.push(p);
            stack.push(st);
        }
    }
    if(stack.length == 0){
        return true;
    }
    return false;
}