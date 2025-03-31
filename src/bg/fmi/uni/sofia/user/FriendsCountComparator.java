package bg.fmi.uni.sofia.user;

import java.util.Comparator;

public class FriendsCountComparator implements Comparator<UserProfile> {

    @Override
    public int compare(UserProfile user1, UserProfile user2) {
        return Integer.compare(user1.getFriends().size(), user2.getFriends().size());
    }
}
