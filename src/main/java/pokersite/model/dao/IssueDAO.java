package pokersite.model.dao;

import pokersite.model.entity.Issue;
import pokersite.model.entity.Message;

import javax.persistence.EntityManager;
import java.util.List;

public class IssueDAO extends GenericDAO<Issue> {
    public IssueDAO() {
        super(Issue.class);
    }
    public List<Issue> getIssues() {
        EntityManager em = getEntityManager();

        //language=sql
        String query = "SELECT u FROM " + getTableName() + " u";
        List<Issue> issues;

        issues = em.createQuery(query, Issue.class).getResultList();
        em.close();

        return issues;
    }
}