package server.repository;

import server.database.DBConn;
import server.entity.Contact;
import server.utils.Constants;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactRepository implements AppRepository<Contact>{

    private final static String TABLE_CONTACTS = "contacts";

    @Override
    public String create(Contact contact) {
        String sql = "INSERT INTO " + TABLE_CONTACTS +
                " (name, phone) VALUES(?, ?)";
        try (PreparedStatement pstmt = DBConn.connect().prepareStatement(sql)) {
            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getPhone());
            pstmt.executeUpdate();
            return Constants.DATA_INSERT_MSG;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    @Override
    public Optional<List<Contact>> read() {
        try (Statement stmt = DBConn.connect().createStatement()) {
            List<Contact> list = new ArrayList<>();
            String sql = "SELECT id, name, phone FROM " + TABLE_CONTACTS;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new Contact(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("phone")
                        )
                );
            }
            return Optional.of(list);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    @Override
    public String update(Contact contact) {
        // Спершу перевіряємо наявність об'єкта в БД за таким id.
        // Якщо ні, повертаємо повідомлення про відсутність таких даних,
        // інакше оновлюємо відповідний об'єкт в БД
        if (readById(contact.getId()).isEmpty()) {
            return Constants.NO_DATA_MSG;
        } else {
            String sql = "UPDATE " + TABLE_CONTACTS +
                    " SET name = ?, phone = ? WHERE id = ?";
            try (PreparedStatement pst = DBConn.connect().prepareStatement(sql)) {
                pst.setString(1, contact.getName());
                pst.setString(2, contact.getPhone());
                pst.setLong(3, contact.getId());
                pst.executeUpdate();
                return Constants.DATA_UPDATE_MSG;
            } catch (SQLException e) {
                return e.getMessage();
            }
        }
    }

    @Override
    public String delete(Long id) {
        // Спершу перевіряємо наявність такого id в БД.
        // Якщо ні, повертаємо повідомлення про відсутність
        // таких даних в БД, інакше видаляємо відповідний об'єкт
        // із БД.
        if (!isIdExists(id)) {
            return Constants.NO_DATA_MSG;
        } else {
            String sql = "DELETE FROM " + TABLE_CONTACTS + " WHERE id = ?";
            try (PreparedStatement pst = DBConn.connect().prepareStatement(sql)) {
                pst.setLong(1, id);
                pst.executeUpdate();
                return Constants.DATA_DELETE_MSG;
            } catch (SQLException e) {
                return e.getMessage();
            }
        }
    }

    @Override
    public Optional<Contact> readById(Long id) {
        String sql = "SELECT id, name, phone FROM " + TABLE_CONTACTS +
                " WHERE id = ?";
        try (PreparedStatement pst = DBConn.connect().prepareStatement(sql)) {
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            Contact contact = new Contact(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("phone")
            );
            return Optional.of(contact);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    // Перевірка наявності певного id у БД
    private boolean isIdExists(Long id) {
        String sql = "SELECT COUNT(id) FROM " + TABLE_CONTACTS +
                " WHERE id = ?";
        try {
            PreparedStatement pst = DBConn.connect().prepareStatement(sql);
            pst.setLong(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                // Очікуємо лише один результат
                if (rs.next()) {
                    return rs.getBoolean(1);
                }
            }
        } catch (SQLException e) {
            return false;
        }
        return false;
    }


}
