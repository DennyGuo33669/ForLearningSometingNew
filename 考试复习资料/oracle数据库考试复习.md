# 数据库考试复习

```sql
-- 创建表
create table xxx (
    字段名 number primary key,
    字段名 varchar not null
);

-- 插入
insert into table_name(col1,col2) values (col1value,col2value);

-- 修改
update table_name set col=xxx where condition

-- 删除
delete from table_name where condition

-- 查询
select * from table_name

select deptno,count(*) from table_name group by deptno

select * from table_name where condition

select * from table_name where condition order by desc

select max(*),min(*) from table_name

select avg(*) from table_name

CREATE VIEW <视图名> AS <SELECT语句>

select * from view_name order by col1,col2

drop view view_name

create sequence sequence_name
start with num
increment by increment_num
maxvalue 999
cache 10
nocycle
```
