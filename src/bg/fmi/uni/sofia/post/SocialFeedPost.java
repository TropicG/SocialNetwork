package bg.fmi.uni.sofia.post;

import bg.fmi.uni.sofia.user.UserProfile;

import java.time.LocalDateTime;
import java.util.*;

public final class SocialFeedPost implements Post {

    private static int globalId = 1;

    private final int uniqueId;
    private final UserProfile author;
    private final LocalDateTime timeOfUpload;
    private final String content;
    private Map<ReactionType, Set<UserProfile>> reactions;

    public SocialFeedPost(UserProfile author, String content){
        this.uniqueId = globalId++;
        this.author = author;
        this.timeOfUpload = LocalDateTime.now();
        this.content = content;
        this.reactions = new EnumMap<>(ReactionType.class);
    }

    @Override
    public boolean addReaction(UserProfile userProfile, ReactionType reactionType) {

        if(!reactions.containsKey(reactionType)) {
            Set<UserProfile> setUsers = new HashSet<>();
            setUsers.add(userProfile);
            reactions.put(reactionType, setUsers);
        }
        else {
            //if the user has an old reaction, we remove it
            for (Set<UserProfile> value : reactions.values()) {
                value.remove(userProfile);
            }

            reactions.get(reactionType).add(userProfile);
        }

        return true;
    }

    @Override
    public boolean removeReaction(UserProfile userProfile) {

        for(var sets : reactions.values()) {
            if(sets.contains(userProfile)) {
                return sets.remove(userProfile);
            }
        }

        return false;
    }

    @Override
    public int getReactionCount(ReactionType reactionType) {
        return reactions.get(reactionType).size();
    }

    @Override
    public int totalReactionCount() {

        int totalCount = 0;

        for(var reactionType : reactions.keySet()) {
            totalCount += reactions.get(reactionType).size();
        }


        return totalCount;
    }

    @Override
    public int getUniqueId() {
        return uniqueId;
    }

    @Override
    public UserProfile getAuthor() {
        return author;
    }

    @Override
    public LocalDateTime getPublishedOn() {
        return timeOfUpload;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public Map<ReactionType, Set<UserProfile>> getAllReactions() {
        return reactions;
    }

    @Override
    public String toString(){

        return "Unique ID:[" +  uniqueId + "] Author:[" + author.getUsername() + "] Content:[" + content + "]" + '\n' + reactions.toString();
    }


}
