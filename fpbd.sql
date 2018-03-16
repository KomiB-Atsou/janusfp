-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Ven 16 Mars 2018 à 10:53
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `fpbd`
--

-- --------------------------------------------------------

--
-- Structure de la table `banque`
--

CREATE TABLE `banque` (
  `id_banque` int(11) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `carte_bancaire`
--

CREATE TABLE `carte_bancaire` (
  `id_carte_bancaire` bigint(20) NOT NULL,
  `code_crypto` varchar(255) DEFAULT NULL,
  `echeance` datetime DEFAULT NULL,
  `numerocb` varchar(255) DEFAULT NULL,
  `type_carte` varchar(255) DEFAULT NULL,
  `id_client` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id_client` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `numero_compte` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `type_client` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `client_comptes_bancaires`
--

CREATE TABLE `client_comptes_bancaires` (
  `client_idClient` bigint(20) NOT NULL,
  `comptes_bancaires_idCompte` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `client_interne`
--

CREATE TABLE `client_interne` (
  `agency` bit(1) DEFAULT NULL,
  `annee_arrivee` datetime DEFAULT NULL,
  `numero_contrat` varchar(255) DEFAULT NULL,
  `numero_portable` varchar(255) DEFAULT NULL,
  `id_client` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `date_creation` date DEFAULT NULL,
  `date_derniere_maj` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `forme_compte` int(11) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `mouvementable` bit(1) NOT NULL,
  `solde_courant` double NOT NULL,
  `solde_initial` double NOT NULL,
  `type_compte` int(11) DEFAULT NULL,
  `compte_parent_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`id`, `code`, `date_creation`, `date_derniere_maj`, `description`, `forme_compte`, `libelle`, `mouvementable`, `solde_courant`, `solde_initial`, `type_compte`, `compte_parent_id`) VALUES
(32, NULL, NULL, NULL, NULL, 0, 'Caisse Maison', b'1', 10000, 0, 2, NULL),
(31, NULL, NULL, NULL, NULL, 0, 'Caisse Maison', b'1', 10000, 0, 2, NULL),
(30, NULL, NULL, NULL, NULL, NULL, NULL, b'0', 0, 0, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `compte_agency`
--

CREATE TABLE `compte_agency` (
  `login` varchar(255) DEFAULT NULL,
  `mot_de_passe` varchar(255) DEFAULT NULL,
  `question_secrete` varchar(255) DEFAULT NULL,
  `reponse_question_secrete` varchar(255) DEFAULT NULL,
  `id_client` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `compte_bancaire`
--

CREATE TABLE `compte_bancaire` (
  `type_compte` varchar(31) NOT NULL,
  `id_compte` bigint(20) NOT NULL,
  `numero_compte` varchar(255) DEFAULT NULL,
  `taux_renumeration` double DEFAULT NULL,
  `decouvert` bit(1) DEFAULT NULL,
  `id_banque` int(11) DEFAULT NULL,
  `id_client` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `compte_comptes_tresorerie`
--

CREATE TABLE `compte_comptes_tresorerie` (
  `compte_id` bigint(20) NOT NULL,
  `comptes_tresorerie_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `compte_tresorerie`
--

CREATE TABLE `compte_tresorerie` (
  `id` bigint(20) NOT NULL,
  `solde_courant` double NOT NULL,
  `solde_initial` double NOT NULL,
  `compte_logique_id` bigint(20) DEFAULT NULL,
  `compte_physique_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `conseiller`
--

CREATE TABLE `conseiller` (
  `id_conseiller` bigint(20) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `id_client_interne` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `conseiller_login`
--

CREATE TABLE `conseiller_login` (
  `login` varchar(255) DEFAULT NULL,
  `mot_de_passe` varchar(255) DEFAULT NULL,
  `id_conseiller` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

CREATE TABLE `operation` (
  `id` bigint(20) NOT NULL,
  `commentaires` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `montant` int(11) NOT NULL,
  `nombre_mois_echelonnement` int(11) NOT NULL,
  `type_operation` int(11) DEFAULT NULL,
  `compte_destination_standard_id` bigint(20) DEFAULT NULL,
  `compte_destination_standard_parent_id` bigint(20) DEFAULT NULL,
  `compte_destination_tresorerie_logique_id` bigint(20) DEFAULT NULL,
  `compte_destination_tresorerie_physique_id` bigint(20) DEFAULT NULL,
  `compte_source_standard_id` bigint(20) DEFAULT NULL,
  `compte_source_standard_parent_id` bigint(20) DEFAULT NULL,
  `compte_source_tresorerie_logique_id` bigint(20) DEFAULT NULL,
  `compte_source_tresorerie_physique_id` bigint(20) DEFAULT NULL,
  `periode_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `periode`
--

CREATE TABLE `periode` (
  `id` bigint(20) NOT NULL,
  `annee` int(11) NOT NULL,
  `en_cours` bit(1) NOT NULL,
  `mois` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `banque`
--
ALTER TABLE `banque`
  ADD PRIMARY KEY (`id_banque`);

--
-- Index pour la table `carte_bancaire`
--
ALTER TABLE `carte_bancaire`
  ADD PRIMARY KEY (`id_carte_bancaire`),
  ADD KEY `FK_c6mxe4c6q7kat7inhtaq914i8` (`id_client`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`);

--
-- Index pour la table `client_comptes_bancaires`
--
ALTER TABLE `client_comptes_bancaires`
  ADD UNIQUE KEY `UK_d7qhux0vw0m2s1kt9ujuoctls` (`comptes_bancaires_idCompte`),
  ADD KEY `FK_id93ngqxndyt564hll4r6p28l` (`client_idClient`);

--
-- Index pour la table `client_interne`
--
ALTER TABLE `client_interne`
  ADD PRIMARY KEY (`id_client`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_jr7xuag330pgslbfclflg7ng8` (`compte_parent_id`);

--
-- Index pour la table `compte_agency`
--
ALTER TABLE `compte_agency`
  ADD PRIMARY KEY (`id_client`);

--
-- Index pour la table `compte_bancaire`
--
ALTER TABLE `compte_bancaire`
  ADD PRIMARY KEY (`id_compte`),
  ADD KEY `FK_3dlwgxsulrur13dovndgsj0hy` (`id_banque`),
  ADD KEY `FK_s58g79viuio4smalhvu4y1vo8` (`id_client`);

--
-- Index pour la table `compte_comptes_tresorerie`
--
ALTER TABLE `compte_comptes_tresorerie`
  ADD UNIQUE KEY `UK_o2yqb3e5pvlr62isriy6a2yll` (`comptes_tresorerie_id`),
  ADD KEY `FK_nhq45aslhy6bo1k74l8aqcjg4` (`compte_id`);

--
-- Index pour la table `compte_tresorerie`
--
ALTER TABLE `compte_tresorerie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_nm2xux8j3eywxrdn05hej9x7e` (`compte_logique_id`),
  ADD KEY `FK_1qkv0tndu955uk1mgvmq7vlk3` (`compte_physique_id`);

--
-- Index pour la table `conseiller`
--
ALTER TABLE `conseiller`
  ADD PRIMARY KEY (`id_conseiller`),
  ADD KEY `FK_k3gj60kbhv68pfehmvx7pra5d` (`id_client_interne`);

--
-- Index pour la table `conseiller_login`
--
ALTER TABLE `conseiller_login`
  ADD PRIMARY KEY (`id_conseiller`);

--
-- Index pour la table `operation`
--
ALTER TABLE `operation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_tdeh56nxlyw9pf7odxeshn8w5` (`compte_destination_standard_id`),
  ADD KEY `FK_e8xns224vlqgab8oddesxywvg` (`compte_destination_standard_parent_id`),
  ADD KEY `FK_2dr7ogexdpb8emwc3pv0o8eds` (`compte_destination_tresorerie_logique_id`),
  ADD KEY `FK_o35i1ew8vhsl3nkpkj0emc4yy` (`compte_destination_tresorerie_physique_id`),
  ADD KEY `FK_m74ogflqgb31qgg6bl8jpplj9` (`compte_source_standard_id`),
  ADD KEY `FK_or92xbabsl138e6bih3fma2w5` (`compte_source_standard_parent_id`),
  ADD KEY `FK_p2ilcb6rkagi31wg5dxclsku4` (`compte_source_tresorerie_logique_id`),
  ADD KEY `FK_qbvjhsrkfc22la6ar2disd6nq` (`compte_source_tresorerie_physique_id`),
  ADD KEY `FK_tmjjinscta8krlu0wkbw4qeo4` (`periode_id`);

--
-- Index pour la table `periode`
--
ALTER TABLE `periode`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `banque`
--
ALTER TABLE `banque`
  MODIFY `id_banque` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `carte_bancaire`
--
ALTER TABLE `carte_bancaire`
  MODIFY `id_carte_bancaire` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT pour la table `compte_bancaire`
--
ALTER TABLE `compte_bancaire`
  MODIFY `id_compte` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `compte_tresorerie`
--
ALTER TABLE `compte_tresorerie`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `conseiller`
--
ALTER TABLE `conseiller`
  MODIFY `id_conseiller` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `operation`
--
ALTER TABLE `operation`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `periode`
--
ALTER TABLE `periode`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
