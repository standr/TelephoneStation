package by.ittc.project.database.dao;

import java.util.List;

import by.ittc.project.model.Service;

public interface ServiceDAO {

	public void addService(final Service service);

	public Service getServiceById(final int id);

	public List<Service> getServicesList();

	public List<Service> getServicesByAccountId(int accountId);

	public void updateService(final Service service);

	public void deleteService(final Service service);

}
