/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author caiok
 */
public class TaskController {

    public void save(Task task) {

        String sql = "INSERT INTO tasks (idProjects, name, description, "
                + "completed, notes, deadline, createdAT, "
                + "updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDiscription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();
            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar tarefa "
                    + ex.getMessage(), ex);
            
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
        
    }

    public void update(Task task) {

    }

    public void removeByID(int taskId) throws SQLException {

        String sql = "DELETE FROM tasks WHERE id = ?";
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();

        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar tarefa");
        } finally {
            ConnectionFactory.closeConnection(conn);
        }
    }

    public List<Task> getAll(int idProject) {
        return null;
    }
}
