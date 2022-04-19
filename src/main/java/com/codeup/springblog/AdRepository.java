package com.codeup.springblog;

import model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {
    Ad findByTitle(String title); // SELECT * FROM ads WHERE title = ?
    Ad findFirstByTitle(String title); // SELECT * FROM ads WHERE title = ? LIMIT 1
}
