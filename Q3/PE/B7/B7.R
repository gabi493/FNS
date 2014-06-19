############################
##### Lectura de datos #####
############################

n <- 5*2*10*3;
n_flotante.com <- 17000000;
n_flotante.es <- 17000000;
n_obsequio.com <- 10500000;
n_obsequio.es <- 10500000;
n_hora.com <- 787000000;
n_hora.es <- 792000000;
n_habanos.com <- 2410000;
n_habanos.es <- 2420000;
n_espaguetis.com <- 2400000;
n_espaguetis.es <- 2400000;

flotante.com <- c(0.43,0.43,0.47,0.15,0.21,0.18,0.21,0.19,0.18,0.19,0.40,0.24,0.18,0.20,0.20,0.25,0.20,0.27,0.20,0.19,0.35,0.16,0.20,0.17,0.20,0.15,0.16,0.17,0.15,0.18);
flotante.es <- c(0.23,0.24,0.18,0.36,0.15,0.22,0.15,0.43,0.19,0.29,0.30,0.18,0.19,0.21,0.28,0.19,0.22,0.19,0.18,0.20,0.27,0.22,0.17,0.16,0.20,0.18,0.18,0.16,0.19,0.17);
obsequio.com <- c(0.37,0.16,0.15,0.15,0.23,0.19,0.18,0.20,0.53,0.19,0.41,0.37,0.16,0.17,0.17,0.19,0.17,0.16,0.25,0.27,0.49,0.23,0.14,0.16,0.14,0.17,0.20,0.16,0.16,0.16);
obsequio.es <- c(0.36,0.15,0.14,0.24,0.18,0.23,0.16,0.15,0.29,0.15,0.30,0.18,0.16,0.16,0.17,0.16,0.20,0.24,0.17,0.17,0.40,0.18,0.17,0.19,0.14,0.16,0.18,0.18,0.15,0.16);
hora.com <- c(0.21,0.16,0.21,0.12,0.14,0.12,0.13,0.12,0.14,0.12,0.18,0.37,0.23,0.29,0.16,0.15,0.16,0.14,0.17,0.17,0.19,0.15,0.13,0.15,0.17,0.16,0.14,0.19,0.14,0.15);
hora.es <- c(0.21,0.15,0.14,0.18,0.25,0.13,0.12,0.24,0.12,0.11,0.14,0.17,0.11,0.13,0.14,0.13,0.23,0.15,0.14,0.15,0.16,0.21,0.20,0.15,0.16,0.17,0.15,0.16,0.15,0.16);
habanos.com <- c(0.29,0.21,0.20,0.38,0.15,0.24,0.20,0.27,0.27,0.17,0.38,0.17,0.16,0.17,0.19,0.15,0.23,0.18,0.15,0.18,0.33,0.25,0.18,0.16,0.28,0.15,0.32,0.18,0.15,0.15);
habanos.es <- c(0.35,0.36,0.23,0.14,0.13,0.27,0.15,0.15,0.37,0.17,0.30,0.19,0.18,0.19,0.16,0.16,0.17,0.17,0.16,0.18,0.17,0.17,0.17,0.17,0.20,0.15,0.19,0.17,0.15,0.20);
espaguetis.com <- c(0.29,0.15,0.16,0.33,0.15,0.33,0.14,0.34,0.17,0.16,0.42,0.16,0.14,0.15,0.15,0.17,0.15,0.16,0.17,0.18,0.23,0.17,0.19,0.15,0.37,0.15,0.16,0.16,0.16,0.16);
espaguetis.es <- c(0.14,0.17,0.15,0.17,0.38,0.23,0.17,0.14,0.17,0.20,0.19,0.23,0.18,0.18,0.18,0.19,0.24,0.16,0.17,0.21,0.26,0.21,0.18,0.18,0.19,0.19,0.17,0.20,0.21,0.19);

.com <- c(flotante.com,obsequio.com,hora.com,habanos.com,espaguetis.com);
.es <- c(flotante.es,obsequio.es,hora.es,habanos.es,espaguetis.es);

mean(flotante.com);
sd(flotante.com);
summary(flotante.com);

mean(flotante.es);
sd(flotante.es);

mean(obsequio.com);
sd(obsequio.com);

mean(obsequio.es);
sd(obsequio.es);

mean(hora.com);
sd(hora.com);

mean(hora.es);
sd(hora.es);

mean(habanos.com);
sd(habanos.com);

mean(habanos.es);
sd(habanos.es);

mean(espaguetis.com);
sd(espaguetis.com);

mean(espaguetis.es);
sd(espaguetis.es);

mean(.com);
sd(.com);

mean(.es);
sd(.es);

tpr_flotante.com <- flotante.com/n_flotante.com*1000000000;
tpr_flotante.es <- flotante.es/n_flotante.es*1000000000;
tpr_obsequio.com <- obsequio.com/n_obsequio.com*1000000000;
tpr_obsequio.es <- obsequio.es/n_obsequio.es*1000000000;
tpr_hora.com <- hora.com/n_hora.com*1000000000;
tpr_hora.es <- hora.es/n_hora.es*1000000000;
tpr_habanos.com <- habanos.com/n_habanos.com*1000000000;
tpr_habanos.es <- habanos.es/n_habanos.es*1000000000;
tpr_espaguetis.com <- espaguetis.com/n_espaguetis.com*1000000000;
tpr_espaguetis.es <- espaguetis.es/n_espaguetis.es*1000000000;

tpr.com <- c(tpr_flotante.com,tpr_obsequio.com,tpr_hora.com,tpr_habanos.com,tpr_espaguetis.com);
tpr.es <- c(tpr_flotante.es,tpr_obsequio.es,tpr_hora.es,tpr_habanos.es,tpr_espaguetis.es);

mean(tpr_flotante.com);
sd(tpr_flotante.com);

mean(tpr_flotante.es);
sd(tpr_flotante.es);

mean(tpr_obsequio.com);
sd(tpr_obsequio.com);

mean(tpr_obsequio.es);
sd(tpr_obsequio.es);

mean(tpr_hora.com);
sd(tpr_hora.com);

mean(tpr_hora.es);
sd(tpr_hora.es);

mean(tpr_habanos.com);
sd(tpr_habanos.com);

mean(tpr_habanos.es);
sd(tpr_habanos.es);

mean(tpr_espaguetis.com);
sd(tpr_espaguetis.com);

mean(tpr_espaguetis.es);
sd(tpr_espaguetis.es);