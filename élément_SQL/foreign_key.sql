ALTER TABLE elementMap ADD CONSTRAINT FK_elementMap_IDelement FOREIGN KEY (IDelement) REFERENCES element(IDelement);
ALTER TABLE elementMap ADD CONSTRAINT FK_elementMap_IDmap FOREIGN KEY (IDmap) REFERENCES map(IDmap);
