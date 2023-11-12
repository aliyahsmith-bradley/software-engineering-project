package pokersite.model.dao;

import pokersite.model.entity.Friendship;

public class FriendshipDAO extends GenericDAO<Friendship> {
    public FriendshipDAO() {
        super(Friendship.class);
    }
}