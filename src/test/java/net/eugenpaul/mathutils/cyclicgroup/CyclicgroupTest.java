package net.eugenpaul.mathutils.cyclicgroup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class CyclicgroupTest {

    @Test
    void testGetGeneratorsOfGroup_mod_5() {
        List<Integer> group = List.of(2, 3);
        assertEquals(group, Cyclicgroup.getGeneratorOfGroup(5));
    }

    @Test
    void test_GetFirstGeneratorOfGroup_from_3_mod_5() {
        assertEquals(3, Cyclicgroup.getFirstGeneratorOfGroup(3, 5));
    }

    @Test
    void test_GetFirstGeneratorOfGroup_mod_5() {
        assertEquals(2, Cyclicgroup.getFirstGeneratorOfGroup(5));
    }

    @Test
    void test_GetFirstGeneratorOfGroup_mod_11() {
        assertEquals(2, Cyclicgroup.getFirstGeneratorOfGroup(11));
    }

    @Test
    void test_GetFirstGeneratorOfGroup_mod_99991() {
        assertEquals(6, Cyclicgroup.getFirstGeneratorOfGroup(3, 99991));
    }

    @Test
    void test_getOrger_gen_6_mod_99991() {
        assertEquals(99990, Cyclicgroup.getOrger(6, 99991));
    }

    @Test
    void test_getGroup_gen_2_mod_5() {
        List<Integer> group = List.of(2, 4, 3, 1);
        assertEquals(group, Cyclicgroup.getGroup(2, 5));
    }

    @Test
    void test_getGroup_gen_3_mod_5() {
        List<Integer> group = List.of(3, 4, 2, 1);
        assertEquals(group, Cyclicgroup.getGroup(3, 5));
    }

    @Test
    void test_getGroup_gen_4_mod_5() {
        List<Integer> group = List.of(4, 1);
        assertEquals(group, Cyclicgroup.getGroup(4, 5));
    }

    @Test
    void test_getGroup_gen_5_mod_100() {
        List<Integer> group = List.of(25);
        assertEquals(group, Cyclicgroup.getGroup(5, 100));
    }

    @Test
    void test_getGroup_gen_2_mod_11() {
        assertEquals(10, Cyclicgroup.getGroup(2, 11).size());
    }
}
