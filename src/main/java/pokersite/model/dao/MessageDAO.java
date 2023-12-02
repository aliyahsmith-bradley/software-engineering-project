package pokersite.model.dao;

import pokersite.model.entity.Message;

public class MessageDAO extends GenericDAO<Message> {
    public MessageDAO() {
        super(Message.class);
    }
}
