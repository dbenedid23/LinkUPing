package dao;

import Utils.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import model.Candidature;
import model.Company;
import model.JobOffer;
import model.Skill;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class JobOfferImplDAO implements JobOfferDAO{
    @Override
    public void removeJobOffer(JobOffer jo) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            JobOffer jobOffer = session.get(JobOffer.class, jo);
            if (jobOffer != null) {
                session.remove(jobOffer);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void updateJobOffer(JobOffer jo) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            if (jo.getId() != 0) {
                session.merge(jo);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println(e);
        }
    }

    @Override
    public List<JobOffer> getJobOffersBySalary(int salary) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<JobOffer> cr = cb.createQuery(JobOffer.class);
            Root<JobOffer> root = cr.from(JobOffer.class);
            cr.where(cb.equal(root.get("maxSalary"), salary));
            return session.createQuery(cr).getResultList();
        } catch (HibernateException hibernateException){
            System.err.println(hibernateException.getMessage());
            return null;
        }
    }

    @Override
    public List<JobOffer> getJobOffersByTitle(String title) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<JobOffer> cr = cb.createQuery(JobOffer.class);
            Root<JobOffer> root = cr.from(JobOffer.class);
            cr.where(cb.equal(root.get("title"), title));
            return session.createQuery(cr).getResultList();
        } catch (HibernateException hibernateException){
            System.err.println(hibernateException.getMessage());
            return null;
        }
    }

    @Override
    public List<JobOffer> getJobOffersBySkills(String skill) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<JobOffer> cr = cb.createQuery(JobOffer.class);
            Root<JobOffer> root = cr.from(JobOffer.class);
            cr.where(cb.equal(root.get("skill"), skill));
            return session.createQuery(cr).getResultList();
        } catch (HibernateException hibernateException){
            System.err.println(hibernateException.getMessage());
            return null;
        }
    }

    @Override
    public List<Candidature> getJobOfferCandidatures(JobOffer jo) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Candidature> cr = cb.createQuery(Candidature.class);
            Root<Candidature> root = cr.from(Candidature.class);
            Join<Candidature, JobOffer> jobOfferJoin = root.join("candidature");
            cr.where(cb.equal(root, jo));
            return session.createQuery(cr).getResultList();
        } catch (HibernateException hibernateException){
            System.err.println(hibernateException.getMessage());
            return null;
        }
    }

    @Override
    public List<JobOffer> getJobOfferByLocation(String location) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<JobOffer> cr = cb.createQuery(JobOffer.class);
            Root<JobOffer> root = cr.from(JobOffer.class);
            cr.where(cb.equal(root.get("location"), location));
            return session.createQuery(cr).getResultList();
        } catch (HibernateException hibernateException){
            System.err.println(hibernateException.getMessage());
            return null;
        }
    }

    @Override
    public List<JobOffer> getJobOffersBySkill(Skill ski) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<JobOffer> cr = cb.createQuery(JobOffer.class);
            Root<JobOffer> root = cr.from(JobOffer.class);
            Join<JobOffer, Skill> jobOfferSkillJoin = root.join("skill");
            cr.where(cb.equal(root, ski));
            return session.createQuery(cr).getResultList();
        } catch (HibernateException hibernateException){
            System.err.println(hibernateException.getMessage());
            return null;
        }
    }

    @Override
    public JobOffer getJobOffer(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<JobOffer> query = cb.createQuery(JobOffer.class);
            Root<JobOffer> root = query.from(JobOffer.class);
            query.where(cb.equal(root.get("id"), id));
            return session.createQuery(query).getSingleResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<JobOffer> getJobOffersByWorkDayType(int workDayType) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<JobOffer> cr = cb.createQuery(JobOffer.class);
            Root<JobOffer> root = cr.from(JobOffer.class);
            cr.where(cb.equal(root.get("workDayType"), workDayType));
            return session.createQuery(cr).getResultList();
        } catch (HibernateException hibernateException){
            System.err.println(hibernateException.getMessage());
            return null;
        }
    }

    @Override
    public void createJobOffer(JobOffer jo) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(jo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<JobOffer> getJobOffersByCompany(Company co) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<JobOffer> cr = cb.createQuery(JobOffer.class);
            Root<JobOffer> root = cr.from(JobOffer.class);
            Join<JobOffer, Company> jobOfferSkillJoin = root.join("jobOffers");
            cr.where(cb.equal(root, co));
            return session.createQuery(cr).getResultList();
        } catch (HibernateException hibernateException){
            System.err.println(hibernateException.getMessage());
            return null;
        }
    }
}
