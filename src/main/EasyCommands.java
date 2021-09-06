package main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class EasyCommands extends JavaPlugin implements Listener{
	public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
	    event.setJoinMessage(ChatColor.GREEN + event.getPlayer().getName() + " ����� �� ������");}
		
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
	    event.setQuitMessage(ChatColor.YELLOW + event.getPlayer().getName() + " ������� ������");}
	
	@Override
	public boolean onCommand (CommandSender sender, org.bukkit.command.Command cmd, String commandLabel, String[] args){
		if (commandLabel.equalsIgnoreCase("info")) {
			Player p = (Player)sender;
			p.sendMessage(ChatColor.YELLOW + "������ EasyCommands:");
			p.sendMessage(ChatColor.GREEN + "������: 1.0");
			p.sendMessage(ChatColor.GREEN + "���������: MishaSok");
			p.sendMessage(ChatColor.GREEN + "GitHub - https://github.com/MishaSok");
		}
		
		if((commandLabel.equalsIgnoreCase("vanish")) || commandLabel.equalsIgnoreCase("v")){
			Player p = (Player)sender;
			if (p.isOp() == true) {
				if (p.hasPotionEffect(PotionEffectType.INVISIBILITY) == false) {
					p.setAllowFlight(true);
					p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0));
					p.setFlying(true);
					p.sendMessage(ChatColor.GREEN + "��� ��� ����� ������ ����������� � �����");}
				
				else {
					p.removePotionEffect(PotionEffectType.INVISIBILITY);
					p.setAllowFlight(false);
					p.setFlying(false);
					p.sendMessage(ChatColor.GREEN + "������ ����������� � ���� ��� ��������");}
			}
			else {
				p.sendMessage(ChatColor.RED + "� ��� ������������ ���� ��� ������������� ���� �������");
				return false;
			}
		}
		
		if(commandLabel.equalsIgnoreCase("gm")) {
			Player p = (Player)sender;
			if (p.isOp() == true) {
				if((args.length) == 0) {
					p.sendMessage(ChatColor.RED + "������������ �������. ����������� /gm [0, 1, 2, 3]");
					return true;}
				if(args[0].equals("0")) {
					p.setGameMode(GameMode.SURVIVAL);}
				else if(args[0].equals("1")) {
					p.setGameMode(GameMode.CREATIVE);}
				else if(args[0].equals("2")) {
					p.setGameMode(GameMode.ADVENTURE);}
				else if(args[0].equals("3")) {
					p.setGameMode(GameMode.SPECTATOR);}
				else {
					p.sendMessage(ChatColor.RED + "����� ������� �� ����������");}
					return true;
				}
			else {
				p.sendMessage(ChatColor.RED + "� ��� ������������ ���� ��� ������������� ���� �������");
				return true;}}
			
		
		if(commandLabel.equalsIgnoreCase("speed")) {
			Player p = (Player)sender;
			if((args.length) == 0 || args[0].equals("0")) {
				p.removePotionEffect(PotionEffectType.SPEED);
				p.sendMessage(ChatColor.YELLOW + "������ �������� ��� �����");}
			
			else if(args[0].equals("1") || args[0].equals("2") || args[0].equals("3") || args[0].equals("4") || args[0].equals("5")) {
				Integer speed = Integer.parseInt(args[0]);
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, speed - 1));
				p.sendMessage(ChatColor.YELLOW + "������ �������� ���������� �� " + speed);}
			
			else {
				p.sendMessage(ChatColor.RED + "������������ �������. ����������� /speed [0, 1, 2, 3, 4, 5]");}}
		
		
		if(commandLabel.equalsIgnoreCase("nether")) {
			Player p = (Player)sender;
			if(p.isOp() == true) {
				double x = p.getLocation().getBlockX();
				double y = p.getLocation().getBlockY();
				double z = p.getLocation().getBlockZ();
				p.teleport(new Location(Bukkit.getWorld("world_nether"), x, y, z));
				p.sendMessage(ChatColor.YELLOW + "�� ���� ��������������� � ��");
				return true;
			}
			else {
				p.sendMessage(ChatColor.RED + "� ��� ������������ ���� ��� ������������� ���� �������");}}
		
		if(commandLabel.equalsIgnoreCase("end")) {
			Player p = (Player)sender;
			if(p.isOp() == true) {
				double x = p.getLocation().getBlockX();
				double y = p.getLocation().getBlockY();
				double z = p.getLocation().getBlockZ();
				p.teleport(new Location(Bukkit.getWorld("world_the_end"), x, y, z));
				p.sendMessage(ChatColor.YELLOW + "�� ���� ��������������� � ���");
				return true;
			}
			else {
				p.sendMessage(ChatColor.RED + "� ��� ������������ ���� ��� ������������� ���� �������");}}
		
		
		if(commandLabel.equalsIgnoreCase("world")) {
			Player p = (Player)sender;
			if(p.isOp() == true) {
				double x = p.getLocation().getBlockX();
				double y = p.getLocation().getBlockY();
				double z = p.getLocation().getBlockZ();
				p.teleport(new Location(Bukkit.getWorld("world"), x, y, z));
				p.sendMessage(ChatColor.YELLOW + "�� ���� ��������������� � ������� ���");
				return true;
			}
			else {
				p.sendMessage(ChatColor.RED + "� ��� ������������ ���� ��� ������������� ���� �������");}}
		return false;
	}
}
