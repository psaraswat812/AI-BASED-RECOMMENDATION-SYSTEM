// package JavaTasks.Task4;

import java.util.*;

// Simple AI-based Recommendation System using user similarity
public class RecommendationSystem {

    // Sample user preferences [User -> Map of Item -> Rating]
    private static Map<String, Map<String, Integer>> userRatings = new HashMap<>();

    public static void main(String[] args) {
        loadSampleData();

        Scanner scanner = new Scanner(System.in);
        System.out.print("🔎 Enter your name (Alice, Bob, Charlie): ");
        String currentUser = scanner.nextLine();

        if (!userRatings.containsKey(currentUser)) {
            System.out.println("❌ User not found in the system.");
            return;
        }

        System.out.println("\n📊 Based on similar users, we recommend:");
        List<String> recommendations = getRecommendations(currentUser);
        if (recommendations.isEmpty()) {
            System.out.println("No new items to recommend 😔");
        } else {
            for (String item : recommendations) {
                System.out.println("👉 " + item);
            }
        }
    }

    // Load sample user ratings for movies/products
    private static void loadSampleData() {
        userRatings.put("Alice", Map.of("Avengers", 5, "Titanic", 3, "Joker", 4));
        userRatings.put("Bob", Map.of("Avengers", 4, "Joker", 3, "Batman", 5));
        userRatings.put("Charlie", Map.of("Titanic", 5, "Batman", 3, "Joker", 4));
    }

    // Get list of recommendations based on similar users' preferences
    private static List<String> getRecommendations(String user) {
        Map<String, Integer> currentUserRatings = userRatings.get(user);
        Set<String> alreadySeen = currentUserRatings.keySet();
        Map<String, Integer> recommendationScores = new HashMap<>();

        // Loop through all other users
        for (String otherUser : userRatings.keySet()) {
            if (otherUser.equals(user)) continue;

            // Get similarity between users (number of common items rated similarly)
            int similarity = getSimilarity(currentUserRatings, userRatings.get(otherUser));
            if (similarity == 0) continue;  // No point in recommending from unrelated user

            // Loop through other user's items and add new unseen ones to recommendation list
            for (Map.Entry<String, Integer> entry : userRatings.get(otherUser).entrySet()) {
                String item = entry.getKey();
                int rating = entry.getValue();
                if (!alreadySeen.contains(item) && rating >= 4) {  // Recommend only high-rated
                    recommendationScores.put(item, recommendationScores.getOrDefault(item, 0) + similarity);
                }
            }
        }

        // Sort recommendations by score
        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(recommendationScores.entrySet());
        sorted.sort((a, b) -> b.getValue() - a.getValue());

        List<String> recommendations = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sorted) {
            recommendations.add(entry.getKey());
        }

        return recommendations;
    }

    // Check how similar two users are — simple count of common item ratings
    private static int getSimilarity(Map<String, Integer> user1, Map<String, Integer> user2) {
        int score = 0;
        for (String item : user1.keySet()) {
            if (user2.containsKey(item)) {
                int rating1 = user1.get(item);
                int rating2 = user2.get(item);
                // Give score if both rated similarly (within 1 point)
                if (Math.abs(rating1 - rating2) <= 1) {
                    score++;
                }
            }
        }
        return score;
    }
}
