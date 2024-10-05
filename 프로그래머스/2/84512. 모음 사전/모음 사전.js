function solution(word) {
    var answer = 0;
    let arr = ['A', 'E', 'I', 'O', 'U'];
    let dict = [];
    function subset(count, w){
        if(count == 5){
            dict.push(w)
            return;
        }
        if(w !== "") dict.push(w)
        for(let i = 0; i < 5; i++){
            subset(count + 1, w + arr[i]);
        }
    }
    subset(0, "");
    console.log(dict);
    dict.forEach((e, i) => {
        if(e == word){
            answer = i + 1;
        }
    })
    
    return answer;
}