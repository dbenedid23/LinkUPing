package dao;

import Utils.HibernateUtil;
import jakarta.persistence.criteria.*;
import jakarta.persistence.criteria.CriteriaQuery;
import model.Candidature;
import model.Company;
import model.JobOffer;
import org.hibernate.Session;
import org.hibernate.*;

import java.util.List;

public class CompanyImplDAO implements CompanyDAO{
    @Override
    public Company getCompanyByName(String companyName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> query = cb.createQuery(Company.class);
            Root<Company> root = query.from(Company.class);
            query.where(cb.equal(root.get("name"), companyName));
            return session.createQuery(query).getSingleResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Candidature> getCandidaturesByJobOffer(Company co, JobOffer jo) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Candidature> query = cb.createQuery(Candidature.class);
            Root<Candidature> root = query.from(Candidature.class);
            Join<Candidature, Company> candidatureCompanyJoin = root.join("jobOffers");
            query.where(cb.equal(root, jo));
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void updateCompany(Company co) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            if (co.getId() != 0) {
                session.merge(co);
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
    public List<JobOffer> getJobOffers(Company co) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<JobOffer> cr = cb.createQuery(JobOffer.class);
            Root<JobOffer> root = cr.from(JobOffer.class);
            Join<JobOffer, Company> jobOfferJoin = root.join("jobOffers");
            cr.where(cb.equal(root, co));
            return session.createQuery(cr).getResultList();
        } catch (HibernateException hibernateException){
            System.err.println(hibernateException.getMessage());
            return null;
        }
    }

    @Override
    public void removeCompany(Company co) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Company company = session.get(Company.class, co);
            if (company != null) {
                session.remove(company);
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
    public void createCompany(Company co) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(co);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Company getCompany(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Company> query = cb.createQuery(Company.class);
            Root<Company> root = query.from(Company.class);
            query.where(cb.equal(root.get("id"), id));
            return session.createQuery(query).getSingleResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
