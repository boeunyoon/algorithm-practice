function solution(numbers, target) {
    var answer = 0;
    
    function rec(count, sum){
        if(count == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        for(let i = 0; i < 2; i++){
            if(i == 0){
                rec(count + 1, sum + numbers[count]);
            }else{
                rec(count + 1, sum - numbers[count]);
            }
        }
    }
    rec(0, 0);
    
    return answer;
}
