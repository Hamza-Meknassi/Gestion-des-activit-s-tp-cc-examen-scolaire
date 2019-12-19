-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Client: 127.0.0.1
-- Généré le: Mer 20 Mai 2015 à 21:54
-- Version du serveur: 5.5.27
-- Version de PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `gestiontachesetudiant`
--

-- --------------------------------------------------------

--
-- Structure de la table `connect`
--

CREATE TABLE IF NOT EXISTS `connect` (
  `usr` varchar(10) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `connect`
--

INSERT INTO `connect` (`usr`, `Date`) VALUES
('root', '2015-05-17'),
('root', '2015-05-18'),
('Bruno', '2015-05-20'),
('root', '2015-05-20'),
('rooty', '2015-05-20'),
('user', '2015-05-20'),
('user', '2015-05-20'),
('user', '2015-05-20'),
('usr', '2015-05-20'),
('root', '2015-05-20'),
('usr', '2015-05-20'),
('root', '2015-05-20'),
('usr', '2015-05-20'),
('usr', '2015-05-20'),
('root', '2015-05-20'),
('usr', '2015-05-20'),
('root', '2015-05-20'),
('usr', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('Bruno', '2015-05-20'),
('Bruno', '2015-05-20'),
('Bruno', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('Bruno', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('Bruno', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('Bruno', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('Bruno', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20'),
('root', '2015-05-20');

-- --------------------------------------------------------

--
-- Structure de la table `examen`
--

CREATE TABLE IF NOT EXISTS `examen` (
  `Semestre` int(11) NOT NULL,
  `DateExamen` date NOT NULL,
  PRIMARY KEY (`Semestre`,`DateExamen`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `examen`
--

INSERT INTO `examen` (`Semestre`, `DateExamen`) VALUES
(1, '2013-01-01'),
(2, '2014-06-13'),
(3, '2015-01-13');

-- --------------------------------------------------------

--
-- Structure de la table `filiere`
--

CREATE TABLE IF NOT EXISTS `filiere` (
  `nomFiliere` varchar(20) NOT NULL,
  `cycle` varchar(30) NOT NULL,
  PRIMARY KEY (`nomFiliere`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `filiere`
--

INSERT INTO `filiere` (`nomFiliere`, `cycle`) VALUES
('AR', 'License 1');

-- --------------------------------------------------------

--
-- Structure de la table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `usr` varchar(20) NOT NULL DEFAULT '',
  `Password` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`usr`,`Password`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `login`
--

INSERT INTO `login` (`usr`, `Password`) VALUES
('Bruno', 'BRUNO'),
('root', '');

-- --------------------------------------------------------

--
-- Structure de la table `matieres`
--

CREATE TABLE IF NOT EXISTS `matieres` (
  `matiere` varchar(30) NOT NULL DEFAULT '' COMMENT 'Nom matiere',
  `Credits` int(1) DEFAULT NULL,
  `nomEnseignant` varchar(15) DEFAULT NULL,
  `TP` tinyint(1) NOT NULL,
  PRIMARY KEY (`matiere`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `matieres`
--

INSERT INTO `matieres` (`matiere`, `Credits`, `nomEnseignant`, `TP`) VALUES
('ALGEBRE 2', 4, 'DR ACHYLE', 0),
('ALGORIMTHMIQUE 1', 5, 'Mr GUIDANA', 0),
('ALGORITHMIQUE 2', 5, 'Mr Guidana', 1),
('ARITHMETIQUE', 4, 'Dr Houpa', 0),
('Atelier de Programmation', 5, 'Mr Tchakounte', 1),
('BASE DE DONNEES', 4, 'Dr DAYANG', 1),
('CAA', 3, 'Dr Achiles', 0),
('Methode Numerique', 3, 'Mr Kadjet', 0),
('PROBABIBILE ET STATISTIQUE', 5, 'Dr TCHOUA', 0),
('SYSTEME DINFORMATION', 3, 'Dr DAYANG', 0),
('Systeme Informatique', 5, 'Dr NLONG', 0),
('TELECOMMUNICATION 1', 4, 'Dr TCHAMA', 0);

-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

CREATE TABLE IF NOT EXISTS `tache` (
  `matiere` varchar(30) NOT NULL,
  `typeTache` varchar(10) NOT NULL,
  `DateComposi` date NOT NULL DEFAULT '0000-00-00',
  `Heure` varchar(10) NOT NULL,
  PRIMARY KEY (`matiere`,`typeTache`,`DateComposi`,`Heure`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tache`
--

INSERT INTO `tache` (`matiere`, `typeTache`, `DateComposi`, `Heure`) VALUES
('CAA', 'CC', '2015-05-19', '11h:00'),
('Systeme Informatique', 'CC', '2015-05-22', '10h:30');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
