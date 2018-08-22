package aug13.add;

class Tv2 {
	boolean power;
	int channel;
	
	void power() {power = !power;}
	void chnnelUp() {++channel;}
	void channelDown() {--channel;}
}
class VCR {
	boolean power;
	int counter = 0;
	void power() {power = !power;}
	void play() {}
	void stop() {}
	void rew() {}
	void ff() {}
}
public class TVCR extends Tv2 {
	VCR vcr = new VCR();
	int counter = vcr.counter;
	
	void play() {
		vcr.play();
	}
	void stop() {
		vcr.stop();
	}
	void rew() {
		vcr.rew();
	}
	void ff() {
		vcr.ff();
	}
}
