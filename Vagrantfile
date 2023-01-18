# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|

  # config.ssh.insert_key = false
  # config.ssh.private_key_path = ["data/ssh/admin_key"]
  # config.vm.provision "shell", inline: <<-SHELL
  #     ssh-copy-id -i data/ssh/admin_key.pub vagrant@192.168.56.80
  #     ssh-copy-id -i data/ssh/admin_key.pub vagrant@192.168.56.81
  #     ssh-copy-id -i data/ssh/admin_key.pub vagrant@192.168.56.82   
  #     sleep 3
  #     service ssh restart
  #   SHELL

  # Serveur virtuel du site web
  config.vm.define "web" do |web|
    web.vm.hostname = "web"
    web.vm.box = "chavinje/fr-bull-64"
    web.vm.network :private_network, ip: "192.168.56.80"
    # Un repertoire partagé est un plus mais demande beaucoup plus
    # de travail - a voir à la fin
    #machine.vm.synced_folder "./data", "/vagrant_data", SharedFoldersEnableSymlinksCreate: false

    web.vm.provider :virtualbox do |v|
      v.customize ["modifyvm", :id, "--name", "web"]
      v.customize ["modifyvm", :id, "--groups", "/S7-projet"]
      v.customize ["modifyvm", :id, "--cpus", "1"]
      v.customize ["modifyvm", :id, "--memory", 2*1024]
      v.customize ["modifyvm", :id, "--natdnshostresolver1", "on"]
      v.customize ["modifyvm", :id, "--natdnsproxy1", "on"]
    end
    web.vm.provision "shell", path: "scripts/install/install_sys.sh"
    web.vm.provision "shell", path: "scripts/install/install_web.sh"
    web.vm.provision "shell", path: "scripts/install/install_myadmin.sh"
    web.vm.provision "shell", path: "scripts/install/install_firewall.sh"
  end

  # Serveur virtuel de la base de données
  config.vm.define "db" do |db|
    db.vm.hostname = "db"
    db.vm.box = "chavinje/fr-bull-64"
    db.vm.network :private_network, ip: "192.168.56.81"
    
    db.vm.provider :virtualbox do |v2|
      v2.customize ["modifyvm", :id, "--name", "db"]
      v2.customize ["modifyvm", :id, "--groups", "/S7-projet"]
      v2.customize ["modifyvm", :id, "--cpus", "1"]
      v2.customize ["modifyvm", :id, "--memory", 2*1024]
    end
    db.vm.provision "shell", path: "scripts/install/install_sys.sh"
    db.vm.provision "shell", path: "scripts/install/install_bdd.sh"
    db.vm.provision "shell", path: "scripts/setup_backup.sh"
  end

  # Serveur virtuel du reverse-proxy
  config.vm.define "reverse-proxy" do |rp|
    rp.vm.hostname = "reverse-proxy"
    rp.vm.box = "chavinje/fr-bull-64"
    rp.vm.network :private_network, ip: "192.168.56.82"
    
    rp.vm.provider :virtualbox do |v3|
      v3.customize ["modifyvm", :id, "--name", "rp"]
      v3.customize ["modifyvm", :id, "--groups", "/S7-projet"]
      v3.customize ["modifyvm", :id, "--cpus", "1"]
      v3.customize ["modifyvm", :id, "--memory", 2*1024]
      v3.customize ["modifyvm", :id, "--natdnshostresolver1", "on"]
      v3.customize ["modifyvm", :id, "--natdnsproxy1", "on"]
    end
    rp.vm.provision "shell", path: "scripts/install/install_sys.sh"
    rp.vm.provision "shell", path: "scripts/install/install_rp.sh"
  end

end
  