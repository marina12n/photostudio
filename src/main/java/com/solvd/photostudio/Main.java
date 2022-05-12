package com.solvd.photostudio;
import com.solvd.photostudio.dao.jdbc.mysql.CLientDao;
import com.solvd.photostudio.dao.jdbc.mysql.PriceListDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        CLientDao client = new CLientDao();
        LOGGER.info(client.getAllEntity());
        PriceListDao price = new PriceListDao();
        LOGGER.info(price.getAllEntity());

    }
}
