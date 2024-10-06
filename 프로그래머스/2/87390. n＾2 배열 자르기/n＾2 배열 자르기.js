function solution(n, left, right) {
    var answer = [];
    for(let i = left; i <= right; i++){
        let y = Math.floor(i / n);
        let x = i % n
        let num = Math.max(y, x) + 1;
        answer.push(num);
    }
    
    return answer;
}