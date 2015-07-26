package by.ittc.project.service;

import java.util.List;

import by.ittc.project.database.dao.SubscriberDAO;
import by.ittc.project.database.dao.SubscriberDAOImpl;
import by.ittc.project.model.Subscriber;

public class SubscriberService {
	private SubscriberDAO subscriberDAO = new SubscriberDAOImpl();

	public SubscriberDAO getSubscriberDAO() {
		return subscriberDAO;
	}

	public void setSubscriberDAO(SubscriberDAO subscriberDAO) {
		this.subscriberDAO = subscriberDAO;
	}

	public void addSubscriber(Subscriber subscriber) {
		subscriberDAO.addSubscriber(subscriber);
	}

	public void updateSubscriber(Subscriber subscriber) {
		subscriberDAO.updateSubscriber(subscriber);
	}

	public Subscriber getSubscriberById(int id) {
		return subscriberDAO.getSubscriberById(id);
	}

	public Subscriber getSubscriberByUserId(int userId) {
		return subscriberDAO.getSubscriberByUserId(userId);
	}

	public List<Subscriber> getSubscribersList() {
		return subscriberDAO.getSubscribersList();
	}
}
