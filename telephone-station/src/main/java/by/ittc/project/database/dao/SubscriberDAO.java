package by.ittc.project.database.dao;

import java.util.List;

import by.ittc.project.model.Subscriber;

public interface SubscriberDAO {
	void addSubscriber(Subscriber subscriber);

	void updateSubscriber(Subscriber subscriber);

	Subscriber getSubscriberById(int id);

	Subscriber getSubscriberByUserId(int userId);

	List<Subscriber> getSubscribersList();
}
