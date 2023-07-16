package com.norgini.dslist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DslistApplicationTest {

    @Test
    public void testMain() {
        assertDoesNotThrow(() -> {
            DslistApplication.main(new String[]{});
        });
    }
}
