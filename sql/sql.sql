-- MySQL dump 10.13  Distrib 5.7.15, for osx10.11 (x86_64)
--
-- Host: localhost    Database: Perssion2
-- ------------------------------------------------------
-- Server version 5.7.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_dept`
--

DROP TABLE IF EXISTS `sys_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dept` (
   `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '#',
  `name` varchar(25) NOT NULL COMMENT '名称',
  `fullname` varchar(25) NOT NULL COMMENT '全称',
  `sequeen` varchar(100) NOT NULL COMMENT '序列',
  `p_id` int(11) NOT NULL COMMENT '上级部门',
  `status` int(11) NOT NULL COMMENT '状态',
  `create_date` date NOT NULL COMMENT '创建时间',
  `update_date` date NOT NULL COMMENT '更新时间',
  `operator` int(11) NOT NULL COMMENT '操作者',
  `remark` varchar(50) NOT NULL DEFAULT '' COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept`
--

LOCK TABLES `sys_dept` WRITE;
/*!40000 ALTER TABLE `sys_dept` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_resource`
--

DROP TABLE IF EXISTS `sys_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_resource` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '#',
  `p_id` int(11) NOT NULL COMMENT '父级资源',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `url` varchar(100) NOT NULL COMMENT '地址',
  `type` int(11) NOT NULL COMMENT '类型',
  `status` int(11) NOT NULL COMMENT '状态',
  `create_date` date NOT NULL COMMENT '创建时间',
  `update_date` date NOT NULL COMMENT '更新时间',
  `operator` int(11) NOT NULL COMMENT '操作者',
  `remark` varchar(50) NOT NULL DEFAULT '' COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_resource`
--

LOCK TABLES `sys_resource` WRITE;
/*!40000 ALTER TABLE `sys_resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '#',
  `pid` int(11) NOT NULL COMMENT '上级',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `alias` varchar(100) NOT NULL COMMENT '全称',
  `status` int(11) NOT NULL COMMENT '状态',
  `create_date` date NOT NULL COMMENT '创建时间',
  `update_date` date NOT NULL COMMENT '更新时间',
  `operator` int(11) NOT NULL COMMENT '操作者',
  `remark` varchar(50) NOT NULL DEFAULT '' COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_resourece`
--

DROP TABLE IF EXISTS `sys_role_resourece`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_resourece` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '#',
  `role_id` int(11) NOT NULL COMMENT '角色编号',
  `resource_id` int(11) NOT NULL COMMENT '资源编号',
  `status` int(11) NOT NULL COMMENT '状态',
  `create_date` date NOT NULL COMMENT '创建时间',
  `update_date` date NOT NULL COMMENT '更新时间',
  `operator` int(11) NOT NULL COMMENT '操作者',
  `remark` varchar(50) NOT NULL DEFAULT '' COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_resourece`
--

LOCK TABLES `sys_role_resourece` WRITE;
/*!40000 ALTER TABLE `sys_role_resourece` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role_resourece` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '#',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `avartar` varchar(100) NOT NULL COMMENT '头像',
  `account` varchar(32) NOT NULL COMMENT '账号',
  `passwd` varchar(32) NOT NULL COMMENT '密码',
  `email` varchar(32) NOT NULL COMMENT '邮箱',
  `salt` varchar(4) NOT NULL,
  `phone` varchar(20) NOT NULL COMMENT '电话',
  `brithday` date NOT NULL COMMENT '生日',
  `sex` int(11) NOT NULL COMMENT '性别',
  `status` int(11) NOT NULL COMMENT '状态',
  `create_date` date NOT NULL COMMENT '创建时间',
  `update_date` date NOT NULL COMMENT '更新时间',
  `operator` int(11) NOT NULL COMMENT '操作者',
  `remark` varchar(50) NOT NULL DEFAULT '' COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '#',
  `u_id` int(11) NOT NULL COMMENT '用户编号',
  `r_id` int(11) NOT NULL COMMENT '角色编号',
  `status` int(11) NOT NULL COMMENT '状态',
  `create_date` date NOT NULL COMMENT '创建时间',
  `update_date` date NOT NULL COMMENT '更新时间',
  `operator` int(11) NOT NULL COMMENT '操作者',
  `remark` varchar(50) NOT NULL DEFAULT '' COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-29 15:37:08
