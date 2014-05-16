DROP TABLE m_code;
CREATE TABLE M_code (
   m_code_id VARCHAR(10) NOT NULL PRIMARY KEY,
   m_code_name VARCHAR(100) NOT NULL 
);

DROP TABLE code;
CREATE TABLE  code (
   code_id VARCHAR(10) NOT NULL PRIMARY KEY,
   m_code_id VARCHAR(10) NOT NULL REFERENCES m_code(m_code_id),
   code_name VARCHAR(100) 
);

CREATE TABLE  b_user (
   user_id VARCHAR(32) NOT NULL PRIMARY KEY,
   user_name VARCHAR(100) NOT NULL,
   b_role VARCHAR(32),
   b_PASSWORD VARCHAR(28),
   b_status VARCHAR(10),
   create_date VARCHAR(14)
);

CREATE TABLE blog (
   blog_id VARCHAR(32) NOT NULL PRIMARY KEY REFERENCES b_user(user_id),
   title VARCHAR(100) NOT NULL,
   code_id VARCHAR(10) NOT NULL,
   tag VARCHAR(500),
   cnt_display_post INTEGER DEFAULT 15,
   blog_status VARCHAR(10) DEFAULT 'Active',
   image_path VARCHAR(200),
   create_date VARCHAR(14),
   public_blog CHAR(1) NOT NULL DEFAULT 'Y'
);

CREATE TABLE category(
   blog_id VARCHAR(32) NOT NULL REFERENCES blog(blog_id),
   category_id INTEGER NOT NULL PRIMARY KEY,
   category_name VARCHAR(500),
   public_category CHAR(1) NOT NULL DEFAULT 'Y',
   content VARCHAR(1000),
   created_date VARCHAR(14)
);

DROP INDEX pk_post_post_id;
CREATE TABLE post(
   post_id INTEGER NOT NULL,
   user_id VARCHAR(32) NOT NULL,
   blog_id VARCHAR(32) NOT NULL REFERENCES blog(blog_id),
   category_id INTEGER REFERENCES category(category_id),
   title VARCHAR(500),
   content VARCHAR(1000),
   permit_reply CHAR(1) DEFAULT 'A',
   public_post CHAR(1) DEFAULT 'A',
   created_date VARCHAR(14),
   PRIMARY KEY(post_id, user_id)
);

CREATE TABLE tag(
   tag_id INTEGER NOT NULL,
   user_id VARCHAR(32) NOT NULL,
   post_id INTEGER NOT NULL,
   tag_name VARCHAR(30) NOT NULL,
   created_date VARCHAR(14),
   FOREIGN KEY(post_id, user_id) REFERENCES post(post_id, user_id),
   PRIMARY KEY(tag_id, post_id, user_id)
);

CREATE TABLE reply(
   reply_id INTEGER NOT NULL PRIMARY KEY,
   user_id VARCHAR(32) NOT NULL,
   nickname VARCHAR(20),
   ref_id INTEGER,
   post_id INTEGER NOT NULL,
   content VARCHAR(300) NOT NULL,
   created_date VARCHAR(14),
   public_reply CHAR(1) NOT NULL DEFAULT 'Y',
   FOREIGN KEY(user_id, post_id) REFERENCES post(user_id, post_id),
   FOREIGN KEY(ref_id) REFERENCES reply_id
);

DESC m_code;
DESC code;
DESC b_user;
DESC blog;
DESC category;
DESC post;
DESC tag;
DESC reply;

DROP TABLE post;