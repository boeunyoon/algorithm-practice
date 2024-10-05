function solution(storey) {
    var answer = 0;
    while(true){
        if(storey == 0){
            break;
        }
        let one = storey % 10;
        let next = Math.floor(storey / 10);
        if(one > 5){
            answer = answer + (10 - one);
            next += 1;
        }else if(one < 5){
            answer = answer + one;
        }else{
            if(next % 10 >= 5){
                next += 1;
            }
            answer += one;
        }
        storey = next;
    }
    return answer;
}