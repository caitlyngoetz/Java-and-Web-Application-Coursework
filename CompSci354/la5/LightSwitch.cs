using System;
using System.Drawing;
using System.Windows.Forms;

public class LightSwitch : Form
{
    private Button Button;
    private Label Binary;
    private int count;

    public LightSwitch() {
        init();
        this.count = 0;
    }

    private void init(){
        this.Button = new System.Windows.Forms.Button();
        this.Binary = new System.Windows.Forms.Label();
        this.SuspendLayout();
        //
        // Button
        //
        this.Button.Location = new System.Drawing.Point(130, 12);
        this.Button.Name = "Button";
        this.Button.Size = new System.Drawing.Size(75, 23);
        this.Button.TabIndex = 0;
        this.Button.Text = "On";
        this.Button.UseVisualStyleBackColor = true;
        this.Button.Click += new System.EventHandler(this.Button_Click);
        //
        // Binary
        //
        this.Binary.AutoSize = true;
        this.Binary.Location = new System.Drawing.Point(222, 17);
        this.Binary.Name = "Binary";
        this.Binary.Size = new System.Drawing.Size(13, 13);
        this.Binary.TabIndex = 1;
        this.Binary.Text = "0";
        //
        // LightSwitch
        //
        this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
        this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
        this.ClientSize = new System.Drawing.Size(386, 176);
        this.Controls.Add(this.Binary);
        this.Controls.Add(this.Button);
        this.Name = "LightSwitch";
        this.Text = "Light Switch";
        this.ResumeLayout(false);
        this.PerformLayout();
    }

    private void Button_Click(object sender, EventArgs e) {
        Button.Text = Button.Text.Equals("On") ? "Off" : "On";
        Binary.Text = ToBinaryString(++count);
    }

    private string ToBinaryString(int num) {
        if (num == 0)
            return "0";

        string val = "";
        while (num > 0){
            val = (num & 1) + val;
            num = num >> 1;
        }

        return val;
    }

    public static void Main() {
        Application.Run(new LightSwitch());
    }
}
