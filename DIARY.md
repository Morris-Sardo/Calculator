
13/11/2023
Infortunally since I have started the coursework too early, I have made many errors in actually commit, text commit, useless feature- brabch one and made multiple clone. 


13/11/2023
The works has been so far is:  
    -Import exist maven projecdt into eclips.
    -Create test folder as the project provide to has it was not in.
    -Fix the  package's name variable's name more formal.
    -Tested my prevously code done in coursekwork 1 when placed in provided initial project.(it has been done just  
     to be sure the my previous code could still working).  

This repository has been created to store your CS2800 work.

13/11/2023
-I have added test for push() pop() top() and size() one for class Stack and OpStack  classes.
-Fixed bug pop() in Stack class. The bug was relate to base case. The base case used threw a exception if size == 1 or size == 0.
Bug fixed after eliminate size == 1. 


14/11/2023.
-Implementing push() , pop(), top() and size() methods in StrStac class. All method i try make them more general using random entry.
-I have only ccomplited push() and size() task.


15/11/2023
-STACK
    -Adding test on top() method just to be sure that the method one has not any bugs.
    -Adding test on pop() method just to be sure that the method one has not any bugs. 
    -Fixed spelling errors.
    -Get ready to merge into main branch.
    -MISSING TO CREATE CANDIDATE RELEASE BRANCH(I WANT DEVELOP THE GUI. I WILL COME BACK LEATER).-
    -Fixed first merging conflit.

-GUI
    I DID NOT DO THIS YET.
    -create feature-GUI branch.
    -Working on GUI interface and testing it.
    -merge back in main.
    -Create a candidate release branch[Release-1].
    -Make some more test.
    -Update README file.

16/11/2023
RELEASE-1
    -Create candidate relaease-1 branch.
    -Create CHANGEBLOG.md file reserved by bug fixed.
    -Used cherry-pick for merging commit from candidate release-1 branch to fauter-fixVarName branch anf tagged. After decide to merging  all branch. create my first tag.
    -Fixed couple of merge conflict.
-FEATURE-CALCULATOR
    -Create feaute-CALCULATOR.
    -Update README.md file with my journey.
    -Create StandarCalculator class.
    -Create RevPolishCalc class.

17/11/2023

CREATE NOTES.md

RELELASE-1
    -Create some moere test and and  close tag it.

FEATURE-GUI.
    -Create new GUI. Upload Feaute-gui testing little bit. merging commit.


21/11/2023 
    -Merge feature-GUI into main.
    -Create relese-2.
        -create CHANGELOG file.
        -tag it
        

18/11/2023
    -Started Implementation StandardCalc class. During implenentation found bug in NumbStack, OpStack and StrStack. The bugs was the   method in these classes had Entry type. 
    -Bug fixed and refactor done. Now NumStack, OpStack and StrStack they can work with StandardCalc class. 

19/11/2023
    -Carry on with StandsrdCalsc class.
    -Decived to implement RevPolCalc class.

20/11/2023
    -RevPolCalc class as been written form the beginning as
     wrong design. 
    -Fixed smell code in top() and pop() method NumStack class. Added try{} catch{} to handle this kind of  exception. 

21/11/2023
    -Finish all required test in RevPolCalc.

22/11/2023
    -Start to implement StadardCalc class. 

23/11/2023
    -Finish StandardClac class. Passed all test. I have not use Opstack as UML required.

26/11/2023
    -Started with implementation of Calculator class.
    -Change evalaute method in Calculator interaface class.
    -Changed UML diagram. 

27/11/2023
    -Crete CalcModelTest.
    -Fixed but in StandrdClac class. added statement that handle tan expression typed in reverse polish.
    -Fixed all bugs in Calculaton test class after modification in StandardCalc.
    -Create release-3 branch. testing all classes create so far.

28/11/2023
    -Fix problem with Eclipse. It suddently does not find anymore all the file. Savae every thing tothe gitlab and and re-clone again.
    
1/12/2023
    -Fiexd checkstyle configuratuion problems. Download the eclipse -java-google-style.xml and added into src/main/resorces.
     -Finishing last  system test into release-3 branch.
     -test 20 in release_3Test class discovered small bug in RevPolish class. Bug was  the number were truncated. ther output was little impredictable. 
     -System test done. All classes has been tested. System work.
    -Create feature-VIEW branch. This branch it will implement an expression using a GUI interface.


4/12/2023
    -Implemented CalcController class, MockView class.
    -Merged Feature-VIEW branch back into the main.
    -Created branch release-4. 
    -System test done. No bugs found.
