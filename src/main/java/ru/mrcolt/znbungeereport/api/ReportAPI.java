package ru.mrcolt.znbungeereport.api;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportAPI {
    public static Boolean isExist(String toPlayer, String fromPlayer) {
        try {
            String query = String.format(
                    "SELECT id FROM `reports` WHERE `to_player` = '%s' AND `from_player` = '%s'",
                    toPlayer,
                    fromPlayer
            );
            ResultSet result = MySQLAPI.get(query);
            return result.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void setReport(String toPlayer, String fromPlayer, String reason, Long date) {
        String query = String.format(
                "INSERT INTO `reports` (`id`, `to_player`, `from_player`, `reason`, `date`) VALUES (NULL, '%s', '%s', '%s', '%d')",
                toPlayer,
                fromPlayer,
                reason,
                date);
        MySQLAPI.execute(query);
    }

    public static void removeReport(String toPlayer, String fromPlayer) {
        String query = String.format(
                "DELETE FROM `reports` WHERE `to_player` LIKE '%s' AND `from_player` LIKE '%s'",
                toPlayer,
                fromPlayer);
        MySQLAPI.execute(query);
    }

}
