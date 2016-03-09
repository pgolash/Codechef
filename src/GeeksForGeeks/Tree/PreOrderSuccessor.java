package GeeksForGeeks.Tree;

/**
 * Created by prashantgolash on 07/01/16.
 */
public class PreOrderSuccessor {
    public TreeNode getPreOrderSuccessor(TreeNode root, TreeNode n) {
        TreeNode succ = null;
        boolean isDone = false;
        while (!isDone) {
            if (root == n) {
                if (root.left != null) {
                    succ = root.left;
                } else if (root.right != null) {
                    succ = root.right;
                }
                isDone = true;
            } else if (root.val > n.val) {
                if (root.right != null) {
                    succ = root.right;
                    root = root.left;
                }
            } else {
                root = root.right;
            }
        }
        return succ;
    }
}

























// paint fence

// My blog
Graduated from ISM Dhanbad in the year 2008. Its' been around 7 years and 7 months of experience I have in software industry.

Bitter experiences (Professional)
---------------------------------
- BR : Vinodh and Gagan were smart people. I was not able to leave my impression of being smart. I was only able to potray myself as hardworking individual.
- College: Same this happened in my college.
- Am I really smart of just hardworking. Why I am not able to crack the shell.



Mind condition
--------------
- Watching television so that Priyansha feels good
- Watching television alone, because I don't know what I like. I don't have a dedicated path.
- Now a days my routine is to watch television and eat
- Go for grocery with Priyansha and nothing much
- Comfort Zone

Unsuccessful efforts
--------------------
- Work of my own [0%]
- TopCoder [(]Not even 1%]
- Programming Camp syllabus [Not even 1%]
- App of my own [0%]
- Champion of Search Domain

Skills to improve
-----------------
Anxiety:

Fear:

Confidence:

Area of interest:

Friends:
    Ego

Smartness:
    
    Mind

Lazy:

Jealousy:
- I get jealous with couples who are socializing because I myself is not doing the same.
- I get jealous from people who are earning good.


Grudges:
- With Rwr : Still hold the grudge against Rwr for college time not able to solve puzzle, college time CAT percentile.
- I hold grudges if someone does not treat me well even if that is unintentional.


Anger:


Worry of Priyansha:
------------------
I worry because Priyansha's social life is zero because of me. I am not taking her to any of my friend's place since November 2015.
I have gone to Anand's home once, Subham's home once, Sudhir's home once and Rajeev's home couple of times. Nothing else.
Only once people came to our house, and only couple of times of Rajeev came to our house. I am not able to help in this regard.
I want her to start a job quickly, but I am not doing anything in that regard as well.

College:
Personal:
I married to Priyansha in the 2/2015. She is living with me in Bellevue since last one year.


Experience:
------------
9/2008 - 7/2010
I started with Cisco Systems in Bangalore in the year 2008. Instead of joining CDO, I joined Cisco Services Division which I believe was not the topmost division.
For two years, I just worked on NMS (Network management system). Learned Basic java, Wrote one multithreaded module for file scheduling. Nothing fancy.
Learnt basics of Spring Webflow. I have had this peculiar habit of not able to finish any learning which I have desired. I became build expert. 2 years of basic learning and nothing much
I would say. 

7/2010 - 12/2012
I joined Microsoft WinSE group. The group used to fix bugs only. I spent 2.5 years working on Active Directory. I improved only on debugging and nothing much.
From coding perspective, here I started doing CodeChef and got little good experience. In coding world, I was not able to establish anything substantial. 
I tried to appear in interviews in Facebook, but not able to gave in December 2012. (In July 2012 two of my team mates Gautam and Srinidhi joined Facebook just after IPO).
Subsequently Ashish Pant joined Google. I appeared in Google interview in the year 2012 November, and got rejected in Telephonic itself. I appeared in Amazon and got rejected
in 2nd round itself in my first attempt, later I tried again second time in November 2012 but got rejected again (This time they asked my package and then rejected).
I got offer from DirectI, Bloomreach and Vizury interactive (By cheating).

1/2013 - 7/2014
I worked in BR for this period and it was good learning experience for me. I came to know lot of things.

7/2014 - Till today
I joined Microsoft again in the same team doing same bullshit work. This time I joined with a motive to come to USA.
Learning wise I did learn basics of ADFS.  Coding and desining wise I did nothing. I appeared in Linkedin, Palantir, Uber, Pivotal, Cynogen, Groupon, Amazon, Yelp and Pinterest
interview.




