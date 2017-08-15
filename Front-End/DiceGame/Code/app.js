/*
GAME RULES:

- The game has 2 players, playing in rounds
- In each turn, a player rolls a dice as many times as he whishes. Each result get added to his ROUND score
- BUT, if the player rolls a 1, all his ROUND score gets lost. After that, it's the next player's turn
- The player can choose to 'Hold', which means that his ROUND score gets added to his GLBAL score. After that, it's the next player's turn
- The first player to reach 100 points on GLOBAL score wins the game

*/


//Declare Variables
var scores,roundScore, activePlayer;
function init(){
scores = [0,0];
roundScore = 0;
activePlayer = 0;
    //To remove dice at beging of app
document.querySelector('.dice').style.display= 'none';

document.getElementById('score-0').textContent = '0';
document.getElementById('score-1').textContent = '0';
document.getElementById('current-0').textContent = '0';
document.getElementById('current-1').textContent = '0';
}
init();


//EVENT: When we click roll dice the below code will be executed.
document.querySelector('.btn-roll').addEventListener('click',function(){
1. //Generates random value
    var dice = Math.floor(Math.random()*6)+1;
2. //Display dice
    var diceDOM = document.querySelector('.dice');
    diceDOM.style.display='block';
    diceDOM.src = 'dice-'+dice+'.png';
3.// Update the round score if the rolled number was not a 1
    if(dice !== 1){
       //add score
       roundScore+=dice; 
       document.querySelector('#current-' + activePlayer).textContent = roundScore;
    }
    else{
        
        
      nextPlayer();  
    
    }
});

//EVENT: When we click the hold button it should update the actual score 

document.querySelector('.btn-hold').addEventListener('click',function(){
    document.querySelector('.dice').style.display='none'
    //add  current score to global score backend
    scores[activePlayer]+=roundScore;
    //update front end actual score
    document.querySelector('#score-'+activePlayer).textContent = scores[activePlayer];
     //check if player won
    if(scores[activePlayer]>=100){
      document.querySelector('#name-'+activePlayer).textContent = 'Winner!' 
      document.querySelector('.dice').style.display='none';  
    }
    else{
    //change the activePlayer
     nextPlayer();
    }
    
});

function nextPlayer(){
        //clear current score
        roundScore=0;
        document.querySelector('#current-' + activePlayer).textContent = roundScore;
        //change player on backend player
        activePlayer ===0 ? activePlayer =1 :activePlayer =0;
        //Change player on front end
        /*document.querySelector('.player-0-panel').classList.remove('active');
        document.querySelector('.player-1-panel').classList.add('active');
        */
        document.querySelector('.player-0-panel').classList.toggle('active');
        document.querySelector('.player-1-panel').classList.toggle('active');
        document.querySelector('.dice').style.display='none'
    }


//Event: New Game

document.querySelector(".btn-new").addEventListener('click',init);























/*
//To read/get the value from the web page
var x=document.querySelector('#score-'+activePlayer).textContent;
3. //Assigning dice score to current score in two ways
   //the main function of these two is to set values
   //method 1 (Assigned value will be represented as text): 
    document.querySelector('#current-' + activePlayer).textContent = dice;
   //method 2 (Assigned value will be represented as html): 
  //document.querySelector('#current-' + activePlayer).innerHTML ='<em>' + dice +'</em>'


*/















































