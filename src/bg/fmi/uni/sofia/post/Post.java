package bg.fmi.uni.sofia.post;

import bg.fmi.uni.sofia.user.UserProfile;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

public interface Post {

    boolean addReaction(UserProfile userProfile, ReactionType reactionType);
    boolean removeReaction(UserProfile userProfile);

    int getReactionCount(ReactionType reactionType);
    int totalReactionCount();

    int getUniqueId();
    UserProfile getAuthor();
    LocalDateTime getPublishedOn();
    String getContent();
    Map<ReactionType, Set<UserProfile>> getAllReactions();
}
