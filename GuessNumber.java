// BENEDICT BOLTON
// HW#31
// PD08
// 2013-11-25

/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

/*==================================================
  the Breakdown:
  Blah blah blah, yakkity smakkity, and a nice tall glass of OJ...
  ==================================================*/


import cs1.Keyboard; /* must have cs1 dir in same dir as this file 
			for this to work */

public class GuessNumber {

    //instance vars
    private int _lo, _hi, _guessCtr, _target;



    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:  
      post: _lo is lower bound, _hi is upper bound,
            _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int low, int high ) { // a and b?!?!, ain't nobody got time for non descriptive varaible names
	_lo = low;
	_hi = high;
	_guessCtr = 1;
	_target = (int) ( (Math.random() * _hi) + _lo );
    }


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
                        Uses Iteration.
      pre:  
      post: 
      ==================================================*/
    public void playIter() {
	int guess = (_lo - 1); // guess will always be out of range at initialization
	while (guess != _target) {
	    System.out.print("Guess an Interger from 0-100: ");
	    guess = Keyboard.readInt();
	    _guessCtr++;
	    if (guess == _target) {
		break;
	    }
	    else {
		if ( guess > _target ){
		    System.out.println("Your Guess is too High!!!");
		    System.out.println("It Seems Guess Again"); //do not question the grammer, good grammer is only for winners
		}
		else {
		    System.out.println("Your Guess is too Low!!!");
		    System.out.println("It Seems Guess Again"); 
		}
		
	    }
	}
	    System.out.println("DING DING DING! We have a winner! You guessed the elusive mystery number, " + _target+ ", in a mere " + _guessCtr + " tries.");
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
                         Uses Recursion.
      pre:  
      post: 
      ==================================================*/
    public void playRec() {
	int guess = _lo - 1;
	if (guess != _target) {
	    System.out.print("Guess an Interger from 0-100: ");
	    guess = Keyboard.readInt();
	    _guessCtr++;

	    if (guess < _target) {
		System.out.println("Your Guess is too Low!!!");
		System.out.println("It Seems Guess Again"); //failures get bad grammer, you must EARN the good grammer
		playRec();
	    }

	    else if (guess > _target) {
		System.out.println("Your Guess is too High!!!");
		System.out.println("It Seems Guess Again");
		playRec();
	    }
	}
	else {
	    System.out.println("DING DING DING! We have a winner! You guessed the elusive mystery number, " + _target+ ", in a mere " + _guessCtr + " tries.");
	}
    }


    //wrapper for playRec/playIter to simplify calling
    public void play() { 
	//use one or the other below:
	//playRec();
	playIter();
    }


    //main method to run it all
    public static void main( String[] args ) {

	//instantiate a new game
	GuessNumber g = new GuessNumber(0,100);

	//start the game
	g.play();
    }


    /*==================================================
      _ _(_) -- 
      pre:  
      post: 
      ==================================================*/
}//end class
