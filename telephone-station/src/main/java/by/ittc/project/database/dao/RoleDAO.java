package by.ittc.project.database.dao;

import by.ittc.project.model.Role;

public interface RoleDAO {
	public int getRoleId(final Role role);
	public Role getRoleById(int id);
}
