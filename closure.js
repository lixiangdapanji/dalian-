function longest_palindrome(str) {
  var longest = '';
  for (var i = 0; i < str.length; i++) {
    for (var j = i+1; j <= str.length; j++){
      //console.log(str.slice(i,j));
      if(str.slice(i,j) == str.slice(i,j).split('').reverse().join('')){
        //console.log(str.slice(i,j));
        if(str.slice(i,j).length > longest.length) {
          longest = str.slice(i,j);
        }
      }
    }
  }
  return longest;
}

function stopWatch() {
  var startTime = Date.now();

  function getDelay() {
    var elapsedTime = Date.now() - startTime;
    alert(elapsedTime);
  }
  return getDelay;
}
function fileRead() {
  var fso, ts, s text; 
  var ForReading = 1; 

  fso = new ActiveXObject("Scripting.FileSystemObject"); 
  ts = fso.OpenTextFile("URL"); 
  while(s = ts.ReadLine() != null) {
    text += s;
  }
  return text;
}
