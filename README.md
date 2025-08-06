# AI-BASED-RECOMMENDATION-SYSTEM
COMPANY : CODETECH IT SOLUTIONS 
NAME : PURANJAY SARASWAT
INTERN ID : CT04DZ1931
DOMAIN : JAVA PROGRAMMING
DURATION : 4 WEEKS
MENTOR : NEELA SANTOSH

DESCRIPTION : 
RecommendationSystem.java – Full Description (500+ words)
The RecommendationSystem Java class provides a basic simulation of an AI-based recommendation system using user similarity. It demonstrates how a simple collaborative filtering approach can be used to generate product or movie recommendations based on user preferences. The algorithm uses a similarity score based on how similarly two users have rated common items.

This class is structured around user-item interactions. Specifically, it holds a static map of user ratings for different items (such as movies). Each user has rated some items from 1 to 5, and the goal of the program is to recommend new, highly-rated items that a user hasn’t seen yet, based on the preferences of similar users.

Data Structure
The userRatings map stores user preferences. It maps a user’s name (String) to another map containing item names and their ratings (Map<String, Integer>). In this implementation, three users – Alice, Bob, and Charlie – have provided ratings for various movies such as Avengers, Titanic, Joker, and Batman.

Program Flow
The main() method begins by loading the sample data using loadSampleData(). This data is hardcoded and mimics real-world user preferences. Then, the program prompts the user to enter their name. If the user exists in the system, it attempts to generate a list of recommendations by calling getRecommendations().

The program then prints recommended items. If there are no suitable recommendations (e.g., all items are already seen), a message indicating no new recommendations is displayed.

Recommendation Algorithm
The recommendation logic is implemented in the getRecommendations(String user) method. Here's how it works:

Identify Already Seen Items:
The system gathers the list of items that the current user has already rated.

Similarity Calculation:
It loops through all other users and calculates a similarity score using the getSimilarity() method. The similarity score is determined by how many items both users have rated similarly (within 1 rating point difference).

Recommendation Scoring:
For each similar user, it examines the items that the current user has not seen. If the other user rated an item highly (4 or 5), it adds the similarity score to that item’s recommendation score.

Sorting:
Once all recommendation scores are collected, the items are sorted in descending order of their score to prioritize the most relevant recommendations.

Return List:
Finally, the sorted items are returned to the main method for display.

Similarity Calculation
The getSimilarity() method determines how similar two users are by counting the number of commonly rated items where their ratings are within a range of ±1. This simplistic approach helps to identify users with similar tastes without involving complex mathematics like cosine similarity or Pearson correlation.

Key Features
Collaborative Filtering: This system follows a user-based collaborative filtering approach.

Lightweight Implementation: It uses only core Java without any external libraries.

Scalable Design: It can be extended to support file or database input instead of hardcoded values.

Limitations
The similarity measure is very basic and may not yield accurate results in real-world scenarios.

There's no handling for rating normalization, item popularity, or bias correction.

Only users with overlapping items can influence recommendations.

Conclusion
This class offers a concise and practical example of how recommendation systems work at a fundamental level. It teaches core concepts like similarity measurement, recommendation scoring, and item ranking without overwhelming the learner with complex algorithms. It’s a good educational tool and a starting point for building more advanced recommendation engines using Java.
